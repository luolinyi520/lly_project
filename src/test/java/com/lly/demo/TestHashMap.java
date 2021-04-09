package com.lly.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    @Test
    public void t1() {

        Map<String, String> map = new HashMap<>(4);

        map.put("zkl", "111");
        map.put("wer", "222");
        map.put("spo", "333");
        map.put("uyt", "444");

        map.put("stt", "555");
        map.put("rre", "666");

    }

}
