package com.lly.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo1 {

    public static void main(String[] args) {
        // 初始值为1
        AtomicInteger atomicInteger = new AtomicInteger(1);
        // 期望值是1，更新值为2，返回true代表更新成功
        System.out.println(atomicInteger.compareAndSet(1, 2));
        // 期望值是1，更新值为3，返回false代表更新失败（最新值已经是2）
        System.out.println(atomicInteger.compareAndSet(1, 3));
    }

}
