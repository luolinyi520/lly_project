package com.lly.stream;

import net.minidev.json.JSONUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDem4 {
    @Test
    public void t1() {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(String.join(", ", array));
        // Apple, Banana, Lemon, Orange
    }

    @Test
    public void t2() {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
        // Apple, Banana, Lemon, Orange
    }

    @Test
    public void t3() {
        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
        stream1.forEach(System.out::println);
    }

    @Test
    public void t4() {
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);
    }

    @Test
    public void t5() {
        // 将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[]{1, 2, 3});
        is.forEach(System.out::println);
        // 将Stream<String>转换为LongStream:
//        LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
    }

    @Test
    public void t6() {
        List<String> list = Lists.newArrayList("Apple", "Banana", "Orange");
        String[] array = list.stream().toArray(String[]::new);
        for (String str : array) {
            System.out.println("str = " + str);
        }
    }

    @Test
    public void t7() {
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);
    }

    @Test
    public void t8() {
        List<String> list = Lists.newArrayList("Orange", "apple", "Banana")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void t9() {
        List<String> list = Lists.newArrayList("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .collect(Collectors.toList()); // [A, B, C, D]
        System.out.println(list);
    }

    @Test
    public void t10() {
        List<String> list = Lists.newArrayList("A", "B", "C", "D", "E", "F")
                .stream()
                .skip(5) // 跳过A, B
//                .limit(3) // 截取C, D, E
                .collect(Collectors.toList()); // [C, D, E]
        System.out.println("list = " + list);
    }

    @Test
    public void t11() {
        Stream<String> s1 = Lists.newArrayList("A", "B", "C").stream();
        Stream<String> s2 = Lists.newArrayList("D", "E").stream();
        // 合并:
        Stream<String> s = Stream.concat(s1, s2);
        System.out.println(s.collect(Collectors.toList())); // [A, B, C, D, E]
    }

    @Test
    public void t12() {
        IntStream list = IntStream.of(1, 2, 3, 4, 5);
//        System.out.println(list.count());
//        System.out.println(list.sum());
        System.out.println(list.allMatch(s -> s > 1));
    }
}
