package com.lly.thread;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Data>> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            Data data = new Data();
            Future<Data> future = executor.submit(new Task(data), data);
            list.add(future);
        }

        for (Future<Data> future : list) {
            System.out.println(future.get().getName());
        }

        executor.shutdown();
    }

}

class Data {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Task implements Runnable {
    Data data;

    public Task(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        data.setName("lyluo");
    }
}
