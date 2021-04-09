package com.lly.demo;

import java.util.Optional;

public class FanXing<A> {
    private A a;

    public FanXing(A a) {
        this.a = a;
    }

    public static <A> FanXing<A> of(A value) {
        return new FanXing<>(value);
    }

    public void say11(A a) {
        System.out.println(a);
    }

    public static <A> void say22(A a) {
        System.out.println(a);
    }

    public static <B> void say(B b) {
        System.out.println(b);
    }


}
