package com.lly.demo.domain;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    boolean aa() default false;

    int bb() default 0;

    String value() default "";

}
