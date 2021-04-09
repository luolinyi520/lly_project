package com.lly.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student extends Person {
    final Logger logger = LoggerFactory.getLogger(Student.class);

    public static void main(String[] args) {
        Student student = new Student();
//        student.foo();
        student.test();
    }

    public void test() {
        System.out.println(log.getClass());
        System.out.println(logger.getClass());
        System.out.println("====================");
        String name = "luolinyi";
        logger.info("my name is {}", name);
    }
}
