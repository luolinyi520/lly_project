package com.lly.demo;

import com.lly.entity.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestOptional {

    @Test
    public void t1() {
        Optional<Integer> optional = Optional.empty();
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse(111));
    }

    @Test
    public void t2() {
//        Optional<String> optional = Optional.of("333");
//        System.out.println(optional.get());
//        System.out.println(optional.isPresent());


        Optional empty = Optional.ofNullable(null);
        System.out.println(empty.isPresent());
        System.out.println(empty);
    }

    @Test
    public void t3() {
        Optional<String> optional = Optional.of("luolinyi");

        optional.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("my name is " + s);
            }
        });

        optional.ifPresent(s -> System.out.println("my name is " + s));

    }

    @Test
    public void t4() {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("1111"));

        Optional<String> optional2 = Optional.ofNullable("2222");
//        System.out.println(optional2.orElse("1111"));

        System.out.println(optional2.orElseGet(() -> "11111"));


        optional.orElseThrow(() -> new RuntimeException("xxx"));


    }


    @Test
    public void t5() {
        String str = "abc";
//        System.out.println(str.substring(1));

//        System.out.println(str.substring(1,2));

        System.out.println(str.substring(0, 1));
        BigDecimal d = new BigDecimal("11.22");

        d = d.setScale(0, BigDecimal.ROUND_DOWN);

        System.out.println(d.toPlainString());

    }

    @Test
    public void t6() {
        isBelong();
    }

    @Test
    public void t7() {
        int a = 3;
        if (a > 1) {
            System.out.println("11");
        } else if (a > 2) {
            System.out.println("22");
        }
    }

    public void isBelong() {
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df2.parse("2019-9-23 07:30");
//            now = df.parse("22:00");
            beginTime = df.parse("06:00");
            endTime = df.parse("22:00");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Boolean flag = belongCalendar(now, beginTime, endTime);
        System.out.println(flag);
    }


    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if ((date.after(begin) || date.equals(begin)) && (date.before(end)) || date.equals(end)) {
            return true;
        } else {
            return false;
        }
    }


    @Test
    public void t8() {
        BigDecimal d1 = new BigDecimal("11");
        BigDecimal d2 = new BigDecimal("3");
        BigDecimal r = d1.divide(d2, 0, BigDecimal.ROUND_HALF_UP);
        BigDecimal r2 = d1.divide(d2, BigDecimal.ROUND_HALF_UP);
        System.out.println(r.toPlainString());
        System.out.println(r2.toPlainString());
    }


    @Test
    public void t9() {
//        Pattern CHAR_END_PATTERN = Pattern.compile("(.*)[^a-zA-Z]([a-zA-Z]+)$");
//        Matcher matcher = CHAR_END_PATTERN.matcher("abc2aa");
//        if (matcher.matches()){
//            System.out.println(matcher.group(1));
//        }
        String str = null;
        System.out.println("1".equals(str));
    }

    @Test
    public void t10() {
        Dog dog = new Dog();
        dog.name = "拉布拉多";

        Dog dog2 = new Dog();

        BeanUtils.copyProperties(dog, dog2);

        System.out.println(dog2.name);
    }

}
