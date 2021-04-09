package com.lly.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest {
    public static void main(String[] args) {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;

    public Integer get() {
        n++;
        return n;
    }
}
