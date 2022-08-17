package com.itrex.java.lab;

import com.itrex.java.lab.constants.ArgumentsValue;
import com.itrex.java.lab.exceptions.ExceptionMessage;
import com.itrex.java.lab.exceptions.SortItException;
import com.itrex.java.lab.input_out.ReaderInput;
import com.itrex.java.lab.sort.Sorting;

import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(ReaderInput.class.getName());

    public static void main(String[] args) throws SortItException {
        if (args.length < 3) {
            throw new SortItException(ExceptionMessage.EXCEPTION_COUNT_ARG);
            }

        try{
        InputArgs object =new InputArgs().getObject(args);

        if (object.getType().equals(ArgumentsValue.TYPE_INTEGER)) {
            Sorting.integerSort(object);
        } else if (object.getType().equals(ArgumentsValue.TYPE_STRING)) {
            Sorting.stingSort(object);
        } else throw new SortItException(ExceptionMessage.EXCEPTION_DATA);
    }catch (SortItException e){
            log.info(e.getMessage());
        }
    }

}
