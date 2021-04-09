package com.lly.juc;

public class MySingleton {
    private static MySingleton mySingleton;

    private MySingleton() {
        System.out.println("创建MySingleton对象");
    }

    public static MySingleton getInstance() {
        if (mySingleton == null) {
//            synchronized (MySingleton.class) {
//                // DCL校验
//                if (mySingleton == null) {
//                    mySingleton = new MySingleton();
//                }
//            }
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            new Thread(() -> {
//                getInstance();
                getInstance2();
            }, "线程" + i).start();
        }

        System.out.println("22");

        System.out.println("11");
    }


    private static class SingletonHolder {
        public static MySingleton singleton = new MySingleton();
    }

    public static MySingleton getInstance2() {
        return SingletonHolder.singleton;
    }

}
