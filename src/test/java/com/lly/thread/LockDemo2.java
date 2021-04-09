package com.lly.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo2 {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("外层");
                lock.lock();
                try {
                    System.out.println("中层");
                    lock.lock();
                    try {
                        System.out.println("内层");
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();

//        new Thread(() -> {
//            lock.lock();
//            System.out.println("test");
//            lock.unlock();
//        }, "t2").start();
    }

}
