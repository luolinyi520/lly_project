package com.lly.hook;

public class HookTest {
    public static void main(String[] args) {
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("钩子函数执行");
//            }
//        }));
//        //当主动关闭应用
//        while (true);

        String str = "AA中";
        System.out.println(str.matches("[a-z|A-Z\\s]+"));
    }
}
