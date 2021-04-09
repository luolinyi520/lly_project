package com.lly.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {

    private String name;

    private List<Car> carList = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }
}
