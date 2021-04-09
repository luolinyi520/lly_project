package com.lly.test;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.lly.demo.Car;
import com.lly.demo.Inner;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public class TestInner {

    @Test
    public void t1() {
        // 内部类
        Inner.Inner1 inner1 = new Inner().new Inner1();

        // 静态内部类
        Inner.Inner2 inner2 = new Inner.Inner2();
    }

    @Test
    public void t2() {
        ConcurrentMap concurrentMap = Maps.newConcurrentMap();

        concurrentMap.put("1", "111");
        concurrentMap.put("2", "222");

        concurrentMap.forEach((k, v) -> System.out.println(k + "--" + v));
    }

    @Test
    public void t3() {
        aa();

        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                return;
            }
        }

        bb();
    }

    public void aa() {
        System.out.println("111");
        if (1 == 1) {
            return;
        }
        System.out.println("222");
    }

    public void bb() {
        System.out.println("333");
    }


    @Test
    public void t4() {
        List<Car> list = Lists.newArrayList();

//        list.add(new Car("xxx"));

        list.stream().findFirst().ifPresent(car -> {
            System.out.println("111");
        });
    }

    @Test
    public void t5() {
        String str1 = "舱单ST20200915003中收货人企业代码格式不符合规范|舱单ST20200915003中发货人企业代码格式不符合规范|超出截关时间";
        System.out.println(str1.endsWith("|"));

        String str2 = "此单卸货港不能为国内港口,不能确认|";
        System.out.println(str2.endsWith("|"));

        List<String> msgList = Lists.newArrayList();
//        msgList.add("11");
//        msgList.add("22");


        String str3 = Joiner.on("|").join(msgList);
        System.out.println(Joiner.on("|").join(msgList));

    }

    @Test
    public void t6() {
        // 0.679/0.616
        String rate = "0.679/0.616";
        String[] rateStrs = rate.split("/");
        for (String str : rateStrs) {
            System.out.println(str);
        }
    }

    @Test
    public void t7() {
        Object aa = new BigDecimal("22");

        BigDecimal decimal = (BigDecimal) aa;
        System.out.println(decimal.toPlainString());
    }

    @Test
    public void t8() {
        String rex = "[1-9]+";
        String str1 = "aa";
        String str2 = "01";
        String str3 = "1";
        String str4 = "12";
        System.out.println(str1.matches(rex));
        System.out.println(str2.matches(rex));
        System.out.println(str3.matches(rex));
        System.out.println(str4.matches(rex));
    }

    @Test
    public void t9() {
        List<BigDecimal> list = Lists.newArrayList();
        BigDecimal b = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        Optional<BigDecimal> b2 = list.stream().reduce(BigDecimal::add);
        System.out.println(b.toPlainString());
        System.out.println(b2.isPresent());
    }

    @Test
    public void t10() {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("3");

        BigDecimal c = a.divide(b, 0, RoundingMode.HALF_UP);
        System.out.println(c.toPlainString());
    }

    @Test
    public void t11() {
        List<String> list = Lists.newArrayList();
        list.add("aaaa");
        list.add("bbbb");
        System.out.println(list.toString());
    }

    @Test
    public void t12() {
        List<String> list = Lists.newArrayList();
        list.add("aaaa");
        list.add("bbbb");

        int index = 0;
        for (String str : list) {
            index++;
            if (index == list.size()) {
                System.out.println("end");
            }
        }

    }

    @Test
    public void t13() {
        String s = "||||33||";
        String[] ss = s.split("\\|\\|");
        System.out.println(ss.length);
    }

    @Test
    public void t14() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 2) {
                return;
            }
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
            }
        }
    }

    @Test
    public void t15() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-1-1");
        String s = String.format("%td", date);
        System.out.println(s);
        int dayNum = Integer.parseInt(s);
        System.out.println(dayNum);
    }

    @Test
    public void t16() throws ParseException {


    }

    public String a1() {
        String a1 = "111";
        a2(a1);
        return a1;
    }

    public void a2(String a1) {
        a1 += "222";
    }
}
