package com.itrex.java.lab.sort;


import com.itrex.java.lab.InputArgs;
import com.itrex.java.lab.constants.ArgumentsValue;
import com.itrex.java.lab.exceptions.SortItException;
import com.itrex.java.lab.input_out.ReaderInput;
import com.itrex.java.lab.input_out.WriteOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void integerSort(InputArgs inputArgs) throws SortItException {
        List<Integer> one;
        if (inputArgs.getInput().size() == 0) {
            one = new ArrayList<>();
        } else {
            one = ReaderInput.getIntegerData(inputArgs.getInput().get(0));
            if (inputArgs.getInput().size() != 1) {
                for (int i = 1; i < inputArgs.getInput().size(); i++) {
                    List<Integer> two = ReaderInput.getIntegerData(inputArgs.getInput().get(i));
                    one = Sort.merge(one, two);
                }
            }
        }

        if (inputArgs.getMode().equals(ArgumentsValue.MODE_DESC)) {
            Collections.reverse(one);
        }
        WriteOut.writeFile(one, inputArgs.getOutput());
    }

    public static void stingSort(InputArgs inputArgs) throws SortItException {
        List<String> one;
        if (inputArgs.getInput().size() == 0) {
            one = new ArrayList<>();
        } else {
            one = ReaderInput.getStringData(inputArgs.getInput().get(0));
            if (inputArgs.getInput().size() != 1) {

                for (int i = 1; i < inputArgs.getInput().size(); i++) {
                    List<String> two = ReaderInput.getStringData(inputArgs.getInput().get(i));
                    one = Sort.mergeString(one, two);
                }
            }
        }
        if (inputArgs.getMode().equals(ArgumentsValue.MODE_DESC)) {
            Collections.reverse(one);
        }
        WriteOut.writeFile(one, inputArgs.getOutput());
    }

}
