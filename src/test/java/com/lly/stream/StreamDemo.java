package com.lly.stream;

import java.util.Arrays;

public class StreamDemo {
    public static void main(String[] args) {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, StreamDemo::cmp);
        System.out.println(String.join(", ", array));
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
