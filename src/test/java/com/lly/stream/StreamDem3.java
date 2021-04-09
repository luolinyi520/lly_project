package com.lly.stream;

import java.util.Arrays;

public class StreamDem3 {
    public static void main(String[] args) {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }
}
