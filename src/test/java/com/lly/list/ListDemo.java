package com.lly.list;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            list.add(i + "");
        }
    }

}
