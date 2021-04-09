package com.lly.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
            try {
                TimeUnit.SECONDS.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行");
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }, "t2").start();


        if (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " end");


    }

}
