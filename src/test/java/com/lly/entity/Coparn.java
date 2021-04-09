package com.lly.entity;

import java.util.concurrent.Executors;

public class Coparn extends Booking {

    private String aa;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {
//        Coparn coparn = new Coparn();
//        coparn.setAa("a");
//        coparn.setBb("b");
//
//        Object obj = coparn;
//
//        Booking booking = (Booking) obj;
//        System.out.println(booking.getBb());

        // java提供的查看当前机器的CPU核心数
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
