package com.lly.test;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author lyluo
 * @Date 2021/2/5
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();


        //生产者
        producer(delayQueue);

        //消费者
        consumer(delayQueue);

//        while (true){
//            try {
//                TimeUnit.HOURS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 每1000毫秒创建一个对象，放入延迟队列，延迟时间10000毫秒
     *
     * @param delayQueue
     */
    private static void producer(final DelayQueue<DelayedElement> delayQueue) {
        new Thread(new Runnable() {

            public void run() {
                int count = 0;
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    DelayedElement element = new DelayedElement(10000, "test" + count);
                    delayQueue.offer(element);
                    int size = delayQueue.size();
                    System.out.println("delayQueue size:" + size);
                    if (size == 10) {
                        break;
                    }
                    count++;
                }
            }
        }).start();


    }

    /**
     * 消费者，从延迟队列中获得数据,进行处理
     *
     * @param delayQueue
     */
    private static void consumer(final DelayQueue<DelayedElement> delayQueue) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    DelayedElement element = null;
                    try {
                        // 没有满足延时的元素 用poll返回 null
                        // 没有满足延时的元素 用take会阻塞
                        element = delayQueue.poll();
                        if (element == null) {
                            continue;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + "---" + element);
                    if (delayQueue.size() == 0) {
                        break;
                    }
                }
            }
        }).start();
    }
}
