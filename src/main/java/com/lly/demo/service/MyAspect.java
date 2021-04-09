package com.lly.demo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /**
     * 前置通知
     */
    @Before("execution(* com.lly.demo.service.AopService.*(..))")
    public void before(JoinPoint joinPoint) {
//        System.out.println("方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before...前置通知");
    }

    /**
     * 返回后通知
     */
    @AfterReturning("execution(* com.lly.demo.service.AopService.*(..))")
    public void afterReturning() {
        System.out.println("afterReturning...返回后通知");
    }

    /**
     * 后置通知
     */
    @After("execution(* com.lly.demo.service.AopService.*(..))")
    public void after() {
        System.out.println("after...后置通知");
    }

    /**
     * 环绕通知
     */
    @Around("execution(* com.lly.demo.service.AopService.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知之前...");
        Object retValue = proceedingJoinPoint.proceed();
        System.out.println("环绕通知之后...");
        return retValue;
    }

    /**
     * 异常通知
     */
    @AfterThrowing("execution(* com.lly.demo.service.AopService.*(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...异常通知");
    }

}
