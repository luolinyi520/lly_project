package com.lly.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan(basePackages = "com.lly.demo.config")
public class TestConfiguration {

    public TestConfiguration() {
        System.out.println("spring容器启动初始化。。。");
    }

    @Bean(initMethod = "start", destroyMethod = "cleanUp")
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }

}
