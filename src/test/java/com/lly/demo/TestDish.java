package com.lly.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestDish {

    /**
     * 测试TreeSet默认比较器及传入比较器
     */
    @Test
    public void testTreeSet() {
        List<Dish> dishList = new ArrayList<>();
        Dish dish1 = new Dish("001", "张三");
        dishList.add(dish1);
        Dish dish2 = new Dish("001", "李四");
        dishList.add(dish2);
        Dish dish3 = new Dish("002", "王五");
        dishList.add(dish3);

        List<Dish> newDishList = dishList.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Dish::getId))), ArrayList::new));
        newDishList.forEach(d -> System.out.println("id:" + d.getId() + ", name:" + d.getName()));
    }

}
