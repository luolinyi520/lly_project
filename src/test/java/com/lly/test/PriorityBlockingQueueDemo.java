package com.lly.test;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    private static PriorityBlockingQueue<User> blockingQueue = new PriorityBlockingQueue<>();

    static class User implements Comparable<User> {
        String name;
        int age;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            if (this.age > o.getAge()) {
                return 1;
            } else if (this.age < o.getAge()) {
                return -1;
            } else {
                return 0;
            }

//            if (this.age > o.getAge()) {
//                return 1;
//            } else {
//                return -1;
//            }
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
//        List<User> list = new ArrayList<>(3);
//        list.add(new User(20, "EE"));
//        list.add(new User(25, "AA"));
//        list.add(new User(20, "BB"));
//        list.add(new User(29, "CC"));
//        list.add(new User(20, "DD"));
//        System.out.println("排序前："+list.toString());
//        System.out.println();
//        Collections.sort(list);
//        System.out.println("排序后："+list.toString());
//
//        blockingQueue.offer(new User(20, "BB"));
//        blockingQueue.offer(new User(17, "CC"));
//        blockingQueue.offer(new User(25, "AA"));

        blockingQueue.put(new User(20, "BB"));
        blockingQueue.put(new User(17, "CC"));
        blockingQueue.put(new User(25, "AA"));

        System.out.println(blockingQueue.toString());

    }

}
