package com.lly.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        for (int i = 1; i <= 2; i++) {
            threadPoolExecutor.execute(() -> {

                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    @Test
    public void testAbortPolicy() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 1; i <= 9; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    @Test
    public void testCallerRunsPolicy() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // 多余的任务，退回给调用者（这里调用者是main线程）
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }


    @Test
    public void testDiscardOldestPolicy() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // 丢弃等待最久的任务
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    @Test
    public void testDiscardPolicy() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // 直接丢弃任务
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
