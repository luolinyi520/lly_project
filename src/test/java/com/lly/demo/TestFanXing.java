package com.lly.demo;

import org.junit.jupiter.api.Test;

public class TestFanXing {

    @Test
    public void t1() {
        FanXing<String> fanXing = new FanXing<>("11");
        fanXing.say11("1111");
    }

    @Test
    public void t2() {
        FanXing.say("2222");
        FanXing.say22("3333");
    }

    @Test
    public void t3() {


    }

}
