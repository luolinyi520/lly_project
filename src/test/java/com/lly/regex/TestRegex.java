package com.lly.regex;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {


    @Test
    public void t1() {
//        String str = "186217189我们";
//        System.out.println(isValidMobileNumber(str));
        String str = "AAzz BB 中";
        System.out.println(str.matches("[a-z|A-Z\\s]+"));
    }

    @Test
    public void t2() {
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex)); // true
        System.out.println("2100".matches(regex)); // false
    }

    @Test
    public void t3() {
        String re2 = "a\\&c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));
    }

    @Test
    public void t4() {
        String str = "a我c";
        System.out.println(str.matches("a.c"));
    }

    @Test
    public void t5() {
        String str = "A380";
        System.out.println(str.matches("A\\d{3}"));
        System.out.println(str.matches("^A\\d{3}$"));
    }

    @Test
    public void t6() {
        String str = "0734-4709577";
        System.out.println(str.matches("\\d{3,4}\\-\\d{6,8}"));
    }

    @Test
    public void t7() {
        String re = "learn\\s([Jj]ava|[Pp]hp|[Gg]o)";
        System.out.println("learn Java".matches(re));
        System.out.println("learn Php".matches(re));
        System.out.println("learn Go".matches(re));
        System.out.println();
        System.out.println("learn java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn go".matches(re));
    }

    @Test
    public void t8() {
        // 利用分组匹配，从字符串"23:01:59"提取时、分、秒。
        Pattern pattern = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})");
        Matcher matcher = pattern.matcher("00:01:59");
        if (matcher.matches()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }

    @Test
    public void t9() {
        Pattern pattern = Pattern.compile("[0-9]{2}");
        System.out.println(pattern.matcher("12").matches());
    }

    @Test
    public void t10() {
        Pattern pattern = Pattern.compile("^abc");
        Matcher matcher = pattern.matcher("abcd");
        System.out.println(matcher.matches());
    }

    @Test
    public void t11() {
        String str = "abcabc";
        System.out.println(str.matches("abc"));
    }

    @Test
    public void t12() {
        Pattern pattern = Pattern.compile("(\\d?)");
        Matcher matcher = pattern.matcher("12");
        System.out.println(matcher.matches());
    }

    @Test
    public void t13() {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

    @Test
    public void t14() {
//        String str = "Hello, ${name}! You are learning ${lang}!";
//        Pattern pattern = Pattern.compile("\\$\\{[a-z]+\\}");
//        pattern.matcher()
//        Map<String, String> map = Maps.newHashMap();
//        map.put("name", "Bob");
//        map.put("lang", "Java");
    }

    @Test
    public void t15() {
        // 例如一个字符创 2345678，如果是以234开头那么判断为不匹配
        // 2345678    false
        // 234jksdjfg false
        // 243asdjfk  true
        String input = "243asdjfk";
//        Pattern pattern = Pattern.compile("[^2][^3][^4]\\w*");
        Pattern pattern = Pattern.compile("(?!234)\\w*");
        // 若想选择不是以abc开始的行。regex：^(?!abc).*$
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.matches());
    }

    @Test
    public void t16() {
        // 匹配非abc开头的字符串
        String input1 = "abc123";
        String input2 = "aaa123";
        String input3 = "abe123";
        Pattern pattern = Pattern.compile("(?!abc).*");
        System.out.println(pattern.matcher(input1).matches());// fasle
        System.out.println(pattern.matcher(input2).matches());// true
        System.out.println(pattern.matcher(input3).matches());// true
    }

    boolean isValidMobileNumber(String s) {
        // 是否是11位？
        if (s.length() != 11) {
            return false;
        }
        // 每一位都是0~9：
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
