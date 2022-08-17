package com.itrex.java.lab.input_out;

import com.itrex.java.lab.exceptions.SortItException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.itrex.java.lab.exceptions.ExceptionMessage.EXCEPTION_FORMAT;
import static com.itrex.java.lab.exceptions.ExceptionMessage.EXCEPTION_NOT_FOUND_FILE;

public class ReaderInput {

    private static Logger log = Logger.getLogger(ReaderInput.class.getName());

    public static List<Integer> getIntegerData(String fileName) throws SortItException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String s = reader.readLine();
            while (s != null) {
                try {
                    list.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    log.info(e.getMessage() + "\n" + EXCEPTION_FORMAT + " in file " + fileName);
                }
                s = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            log.info(e.getMessage() + "\n" + EXCEPTION_NOT_FOUND_FILE + " with name" + fileName);
        } catch (IOException e) {
            throw new SortItException(EXCEPTION_NOT_FOUND_FILE, e.getCause());
        }
        return list;
    }

    public static List<String> getStringData(String fileName) throws SortItException {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            reader.lines().forEach(line -> list.add(line));
        } catch (FileNotFoundException e) {
            log.info(e.getMessage() + "\n" + EXCEPTION_NOT_FOUND_FILE + " with name" + fileName);
        } catch (IOException e) {
            throw new SortItException(EXCEPTION_NOT_FOUND_FILE, e.getCause());
        }
        return list;
    }

}
