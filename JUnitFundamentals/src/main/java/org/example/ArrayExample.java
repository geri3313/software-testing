package org.example;

import java.util.HashSet;

public class ArrayExample {
    public static String[] removeDuplicates(String[] array) {
        HashSet<String> set = new HashSet<>();
        for (String str : array) {
            set.add(str);
        }
        return set.toArray(new String[0]);
    }
}

