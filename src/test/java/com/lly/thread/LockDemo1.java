package com.lly.thread;

import java.util.concurrent.Callable;

public class LockDemo1 {

    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t外层");
                synchronized (objectLock) {
                    System.out.println(Thread.currentThread().getName() + "\t中层");
                    synchronized (objectLock) {
                        System.out.println(Thread.currentThread().getName() + "\t内层");
                    }
                }
            }
        }, "t1").start();
    }

}
