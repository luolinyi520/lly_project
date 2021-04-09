package com.lly.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        int num = 5;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for (int i = 1; i <= num; i++) {
            int tmp = i;
            new Thread(() -> {
                System.out.println("" + tmp + "上完晚自习，离开教室");
                countDownLatch.countDown();
            }, "" + i).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("班长最后锁门");
    }
}
