package com.lly.config;

import com.lly.demo.config.TestBean;
import com.lly.demo.config.TestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTests {

    @Test
    public void t1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        TestBean tb1 = (TestBean) context.getBean("testBean");
        TestBean tb2 = (TestBean) context.getBean("testBean");
        System.out.println(tb1 == tb2);

        System.out.println("done");
    }

}
