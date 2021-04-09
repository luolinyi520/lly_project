package com.lly.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestList {

    @Test
    public void t1() {
        List<String> list = Arrays.asList("11", "22", "33");

        long c = list.stream().count();

        System.out.println("...");
        System.out.println(c);
    }

    @Test
    public void t2() {
        int a = 1;
        String b = (a == 1 || a == 2) ? "yes" : "no";
        System.out.println(b);
    }

}
