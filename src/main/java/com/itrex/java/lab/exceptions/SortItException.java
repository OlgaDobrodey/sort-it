package com.itrex.java.lab.exceptions;

public class SortItException extends Exception {

    public SortItException(String message) {
        super(message);
    }

    public SortItException(String message, Throwable cause) {
        super(message, cause);
    }
}
