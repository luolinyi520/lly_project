package com.lly.entity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Dog {
    public String name;

    public Dog() {

    }

    public Dog(Map<String, Object> params) {
        Class c = this.getClass();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            try {
                Field field = c.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(this, entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "123");
        Dog dog = new Dog(params);
        System.out.println(dog.name);
    }
}
