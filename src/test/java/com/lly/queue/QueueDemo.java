package com.lly.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue(3);
//        blockingQueue.put("1");
//        blockingQueue.put("2");
//        blockingQueue.put("3");

        QueueDemo demo = new QueueDemo();
        demo.test();
//        System.out.println(demo.head == demo.last);

//        int a;
//        int b;
//        a = b = 3;
//        System.out.println(a + " "+ b);

    }

    private void test() {
        last = head = new Node<String>(null);
        Node<String> node1 = new Node<>("1");
        enqueue(node1);

        Node<String> node2 = new Node<>("2");
        enqueue(node2);

        Node<String> node3 = new Node<>("3");
        enqueue(node3);
    }

    Node head;
    Node last;

    static class Node<E> {
        E item;

        Node<E> next;

        Node(E x) {
            item = x;
        }
    }

    private void enqueue(Node<String> node) {
        // assert putLock.isHeldByCurrentThread();
        // assert last.next == null;
//        last = last.next = node;
        System.out.println("start...");
        last.next = node;
        last = node;
        System.out.println("end...");
    }
}
