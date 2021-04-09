package com.lly.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> names = Stream.of("Bob", "Alice", "Tim").collect(Collectors.toList());
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }


}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person:" + this.name;
    }
}
