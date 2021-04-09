package com.lly.demo;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

    @Test
    public void t1() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream() // 创建流
                .filter(s -> s.startsWith("c")) // 执行过滤，过滤出以 c 为前缀的字符串
                .map(String::toUpperCase) // 转换成大写
                .sorted() // 排序
                .forEach(System.out::println); // for 循环打印

        // C1
        // C2

    }

    @Test
    public void t2() {
        List<Integer> list = Lists.newArrayList();
        IntStream.range(1, 4)
//                .forEach(System.out::println);
                .forEach(s -> {
                    list.add(s);
                });

        list.forEach(System.out::println);

    }

    @Test
    public void t3() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }

    @Test
    public void t4() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase(); // 转大写
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A"); // 过滤出以 A 为前缀的元素
                });

        // map:      d2
        // anyMatch: D2
        // map:      a2
        // anyMatch: A2

    }

    @Test
    public void t5() {
        List<String> list = Lists.newArrayList();

        list.forEach(System.out::println);

    }

    @Test
    public void t6() {
        Function<Integer, Computer[]> computerCreator = Computer[]::new;
        Computer[] computerArray = computerCreator.apply(5);

        Function<Integer, Computer[]> computerCreator2 = (size) -> new Computer[size];
        Computer[] computerArray2 = computerCreator.apply(5);

        Function<Integer, String[]> function = String[]::new;
        String[] strArr = function.apply(5);
    }

    @Test
    public void t7() {
//        InterfaceComputer c = Computer::new;
//        Computer computer = c.say();
//        computer.say();
    }

    @Test
    public void t8() {
        Function<Integer, Integer> function1 = x -> {
            System.out.println("1");
            return x = x * 10;
        };
        Function<Integer, Integer> function2 = function1.andThen(x -> {
            System.out.println("2");
            return x + 10;
        });
//        System.out.println(function1.apply(8));
        System.out.println(function2.apply(8));
    }

    @Test
    public void t9() {
        List<Car> list = new ArrayList<>();
        list.add(new Car(""));
        String str = list.stream().filter(ss -> !StringUtils.isEmpty(ss.getName()))
                .map(Car::getName).collect(Collectors.joining("-"));
        System.out.println("aa" + str + "bb");
    }

    @Test
    public void t10() {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = new BigDecimal("0");

        BigDecimal c1 = new BigDecimal("1");
        BigDecimal c2 = new BigDecimal("1");

        System.out.println(a.equals(c1.subtract(c2)));
    }

    @Test
    public void t11() {
        String str = "20RF";
        String size = str.substring(0, 2);
        String type = str.substring(2, 4);
        System.out.println("size " + size);
        System.out.println("type " + type);
    }

    @Test
    public void t12() {
//        String str1 = new StringBuilder().append("re").append("dis").toString();
//        System.out.println(str1 == str1.intern());
//
//        String str2 = new StringBuilder().append("ja").append("va").toString();
//        System.out.println(str2 == str2.intern());
        String str = "COMPLETED CARGO OPERATION   08th/ 2100L";
        String str2 = "COMPLETED CARGO OPERATION   ";
        System.out.println(str2.length());
    }

    @Test
    public void t13() {
        Object obj = false;
        if (!((Boolean) obj)) {
            System.out.println("eee");
        }
    }

}
