package com.lly.demo;

@FunctionalInterface
public interface Student<A, B> {

    A test(B b);

}
