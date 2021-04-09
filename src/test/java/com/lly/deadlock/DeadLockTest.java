package com.lly.deadlock;

import java.util.concurrent.TimeUnit;

class DeadLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public DeadLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t尝试获得：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 成功拿到：" + lockB);
            }
        }
    }
}

public class DeadLockTest {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new DeadLockThread(lockA, lockB), "t1").start();
        new Thread(new DeadLockThread(lockB, lockA), "t2").start();

        /**
         * linux  ps -ef|grep java  ls -l
         * windows下的java运行程序 也有类似ps的查看进程的命令，但是目前我们需要查看的只是java
         *        jps = java ps     jps -l
         */
    }
}
