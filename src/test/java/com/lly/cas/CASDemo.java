package com.lly.cas;

import sun.misc.Unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static volatile int count = 0;

    /**
     * 不需要加锁，就能保证原子性
     */
    public static void addPlusPlusAtomic() {
        atomicInteger.getAndIncrement();
    }

    /**
     * 需要加synchronized+volatile关键字才能保证原子性
     */
    public static synchronized void addPlusPlus() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 200;
        ExecutorService executor = Executors.newFixedThreadPool(num);

        // 定义200个任务，每个任务执行1000次
        for (int i = 0; i < num; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                for (int j = 0; j < 1000; j++) {
                    addPlusPlus();
                    addPlusPlusAtomic();
                }
            });
        }

        executor.shutdown();
        // 等待子线程执行完成
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        // 输出计算结果
        System.out.println("atomicInteger=" + atomicInteger.get());
        System.out.println("count=" + count);
    }

//    private static final Unsafe unsafe = Unsafe.getUnsafe();
//    /**
//     * value属性的内存偏移量（内存地址）
//     */
//    private static final long valueOffset;
//
//    static {
//        try {
//            // 拿到value属性的内存地址
//            valueOffset = unsafe.objectFieldOffset
//                    (AtomicInteger.class.getDeclaredField("value"));
//        } catch (Exception ex) { throw new Error(ex); }
//    }
//
//    /**
//     * 当前值
//     */
//    private volatile int value;
//
//    public final int getAndIncrement() {
//        return unsafe.getAndAddInt(this, valueOffset, 1);
//    }
//
//    /**
//     * CAS自旋
//     * @param var1 当前对象
//     * @param var2 value属性的内存偏移量（内存地址）
//     * @param var4 1
//     * @return
//     */
//    public final int getAndAddInt(Object var1, long var2, int var4) {
//        // 当前value属性的真实值
//        int var5;
//        do {
//            var5 = this.getIntVolatile(var1, var2);
//        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4)/* 如果期望值与真实值一样，就加一，否则继续循环判断，直到更新成功为止 */);
//
//        return var5;
//    }

}
