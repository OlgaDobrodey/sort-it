package com.itrex.java.lab;

import com.itrex.java.lab.constants.ArgumentsValue;
import com.itrex.java.lab.exceptions.ExceptionMessage;
import com.itrex.java.lab.exceptions.SortItException;

import java.util.ArrayList;
import java.util.List;

public class InputArgs {

    private String mode;
    private String type;
    private String output;
    private List<String> input;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public InputArgs getObject(String[] args) throws SortItException {
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                if (args[i].equals(ArgumentsValue.TYPE_INTEGER)) {
                    this.setType(args[i]);
                    i = getIndexAfterType(args, this, i);

                } else if (args[i].equals(ArgumentsValue.TYPE_STRING)) {
                    setType(args[i]);
                    i = getIndexAfterType(args, this, i);

                } else if (args[i].equals(ArgumentsValue.MODE_ASC) && args.length > 3) {
                    this.setMode(args[i]);
                    i = getIndexAfterMode(args, this);
                } else if (args[i].equals(ArgumentsValue.MODE_DESC) && args.length > 3) {
                    i = getIndexAfterMode(args, this);

                } else throw new SortItException(ExceptionMessage.EXCEPTION_FIRST_ARG);
            } else {
                if (args[i].matches(ArgumentsValue.PATTERN)) {
                    inputList.add(args[i]);
                } else throw new SortItException(ExceptionMessage.EXCEPTION_INPUT_ARG);
            }
        }
        setInput(inputList);
        return this;

    }

    private int getIndexAfterMode(String[] args, InputArgs inputArgs) throws SortItException {
        int i = 0;
        if (args[i+1].equals(ArgumentsValue.TYPE_INTEGER)) {
            inputArgs.setType(args[i+1]);
            i = getNextIndex(inputArgs, args, i);
        } else if (args[i+1].equals(ArgumentsValue.TYPE_STRING)) {
            inputArgs.setType(args[i+1]);
            i = getNextIndex(inputArgs, args, i+1);
        } else throw new SortItException(ExceptionMessage.EXCEPTION_SECOND_ARG);
        return i;
    }

    private int getIndexAfterType(String[] args, InputArgs inputArgs, int i) throws SortItException {
        if (args[i+1].equals(ArgumentsValue.MODE_ASC)) {
            inputArgs.setMode(args[i+1]);
            i = getNextIndex(inputArgs, args, i);
        } else if (args[i+1].equals(ArgumentsValue.MODE_DESC)) {
            inputArgs.setMode(args[i+1]);
            i = getNextIndex(inputArgs, args, i+1);
        } else if (args[i+1].matches(ArgumentsValue.PATTERN)) {
            setMode(ArgumentsValue.MODE_ASC);
            inputArgs.setOutput(args[i+1]);
            i = i+1;
        } else throw new SortItException(ExceptionMessage.EXCEPTION_SECOND_ARG);
        return i;
    }

    private int getNextIndex(InputArgs inputArgs, String[] args, int i) throws SortItException {
        if (args[i+1].matches(ArgumentsValue.PATTERN) && args.length > 3) {
            inputArgs.setOutput(args[i+1]);
            i = i+1;
        } else throw new SortItException(ExceptionMessage.EXCEPTION_THIRD_ARG);
        return i;
    }

    @Override
    public String toString() {
        return "InputArgs{" +
                "mode='" + mode + '\'' +
                ", type='" + type + '\'' +
                ", output='" + output + '\'' +
                ", input=" + input +
                '}';
    }
}
