package com.lly.demo;

@FunctionalInterface
public interface InterfaceComputer {

    void say();

    default void andThen() {
        say();
    }

}
