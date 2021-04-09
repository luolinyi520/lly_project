package com.lly.aop;

import com.lly.demo.DemoApplication;
import com.lly.demo.service.AopService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = {DemoApplication.class})
public class TestAop {

    @Resource
    private AopService aopService;

    @Test
    public void test1() {
        System.out.println("调用开始");
        int rs = aopService.div(10, 2);
        System.out.println("调用结束");
    }

    @Test
    public void test2() {
        System.out.println("调用开始");
        int rs = aopService.div(10, 0);
        System.out.println("调用结束");
    }

//    @Test
//    public void test3() {
//        try {
//            System.out.println("环绕通知之前...");
//            System.out.println("before...前置通知");
//            int a = 10 / 0;
//            System.out.println("环绕通知之后...");
//        } catch (Exception e) {
//            System.out.println("afterThrowing...异常通知");
//        } finally {
//            System.out.println("after...最终通知");
//        }
//
//    }

}
