package com.lly.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程操作资源类
 */
class MyResource {
    /**
     * 总开关
     */
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    /**
     * 阻塞队列容器
     */
    private BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    public void myProduct() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "\t插入队列：" + data + "成功");
            // 为了效果，这里休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t停止生产flag=" + flag);
    }

    public void myConsumer() throws Exception {
        String data = null;
        while (flag) {
//            TimeUnit.SECONDS.sleep(2);
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
//            System.out.println(Thread.currentThread().getName()+"\t"+data);
            // 考虑读取不到的情况返回null（超时）
            if (null == data || "".equalsIgnoreCase(data)) {
//                flag = false;
//                System.out.println(Thread.currentThread().getName()+"\t超过2秒钟没取到数据，消费退出");
//                return;
                continue;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列：" + data + "成功");
        }
        System.out.println(Thread.currentThread().getName() + "\t停止消费flag=" + flag);
    }

    public void stop() {
        this.flag = false;
    }
}

public class MyMQ {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产者启动...");
            try {
                myResource.myProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费者启动...");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        // 休眠5秒，停止
        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
    }

}

