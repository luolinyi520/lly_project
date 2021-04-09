package com.lly.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestFlatMap {

    @Test
    public void t1() {
        Person p1 = new Person("lly");
        p1.getCarList().addAll(Arrays.asList(new Car("宝马525"), new Car("宝马320")));

        Person p2 = new Person("ZZZ");
        p1.getCarList().addAll(Arrays.asList(new Car("奥迪A4L"), new Car("本田CRV")));

        List<Person> personList = Stream.of(p1, p2).collect(Collectors.toList());

        personList.stream().flatMap(p -> p.getCarList().stream()).forEach(System.out::println);
    }

    @Test
    public void t2() {
        List<Foo> foos = new ArrayList<>();

        // 创建 foos 集合
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        // 创建 bars 集合
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

// Bar1 <- Foo1
// Bar2 <- Foo1
// Bar3 <- Foo1
// Bar1 <- Foo2
// Bar2 <- Foo2
// Bar3 <- Foo2
// Bar1 <- Foo3
// Bar2 <- Foo3
// Bar3 <- Foo3

    }

    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }


}
