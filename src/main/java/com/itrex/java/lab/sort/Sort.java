package com.itrex.java.lab.sort;

import com.itrex.java.lab.input_out.ReaderInput;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Sort {

    private static Logger log = Logger.getLogger(ReaderInput.class.getName());

    public static List<Integer> merge(List<Integer> one, List<Integer> two) {
        int left = one.size();
        int right = two.size();

        List<Integer> a = new ArrayList<>();

        int i = 0, j = 0;
        while (i < left && j < right) {
            if (i != 0 && checkSortIntegerList(one.get(i - 1), one.get(i))) {
                i++;
            } else if (j != 0 && checkSortIntegerList(two.get(j - 1), two.get(j))) {
                j++;
            } else if (one.get(i) <= two.get(j)) {
                a.add(one.get(i++));
            } else {
                a.add(two.get(j++));
            }
        }
        while (i < left) {
            i = addNextInteger(one, a, i);
        }
        while (j < right) {
            j = addNextInteger(two, a, j);
        }
        return a;
    }

    public static List<String> mergeString(List<String> one, List<String> two) {
        int left = one.size();
        int right = two.size();
        List<String> a = new ArrayList<>();

        int i = 0, j = 0;
        while (i < left && j < right) {
            if (checkValidString(one.get(i))) {
                i++;
            } else if (checkValidString(two.get(j))) {
                j++;
            } else if (i != 0 && checkSortStringList(one.get(i - 1), one.get(i))) {
                i++;
            } else if (j != 0 && checkSortStringList(two.get(j - 1), two.get(j))) {
                j++;
            } else if (one.get(i).compareTo(two.get(j)) <= 0) {
                a.add(one.get(i++));
            } else {
                a.add(two.get(j++));
            }
        }
        while (i < left) {
            i = addNextString(one, a, i);
        }
        while (j < right) {
            j = addNextString(two, a, j);
        }
        return a;
    }

    private static int addNextInteger(List<Integer> one, List<Integer> a, int i) {
        if (i != 0 && checkSortIntegerList(one.get(i - 1), one.get(i))) {
            i++;
        } else a.add(one.get(i++));
        return i;
    }

    private static int addNextString(List<String> one, List<String> a, int j) {
        if (checkValidString(one.get(j))) {
            j++;
        } else if (j != 0 && checkSortStringList(one.get(j - 1), one.get(j))) {
            j++;
        } else a.add(one.get(j++));
        return j;
    }

    private static boolean checkSortIntegerList(Integer lastElement, Integer element) {
        return lastElement >= element;
    }

    private static boolean checkSortStringList(String lastElement, String element) {
        return lastElement.compareTo(element) >= 0;
    }

    private static boolean checkValidString(String element) {
        return element.split("\\s+").length != 1;
    }
}
