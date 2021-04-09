package com.lly.demo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestGuava {

    @Test
    public void test1() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("1", "aaa");
        multimap.put("1", "bbb");
        multimap.put("2", "ccc");

        multimap.get("1").stream().forEach(System.out::println);
        multimap.get("2").stream().forEach(System.out::println);
    }

    @Test
    public void test2() {

    }

}
