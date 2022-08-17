package com.itrex.java.lab.input_out;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static com.itrex.java.lab.exceptions.ExceptionMessage.EXCEPTION_NOT_FOUND_FILE;


public class WriteOut {

    private static Logger log = Logger.getLogger(ReaderInput.class.getName());

    public static boolean writeFile(List<? extends Object> list, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            list.forEach(element -> {
                        try {
                            writer.write(element + "\n");
                        } catch (IOException e) {
                            log.info(EXCEPTION_NOT_FOUND_FILE + "element - "+ element +" when writing a file " + fileName);
                        }
                    }
            );
        } catch (IOException e) {
            log.info(EXCEPTION_NOT_FOUND_FILE + " when writing a file " + fileName);
            return false;
        }
        return true;
    }

}
