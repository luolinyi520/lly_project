package com.lly.stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDem5 {
    public static void main(String[] args) {
        // 按行读取配置文件:
        List<String> props = Lists.newArrayList("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    Map<String, String> map2 = new HashMap<>();
                    map2.put(ss[0], ss[1]);
                    return map2;
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
