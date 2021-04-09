package com.lly.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateDemo {
//    public static void main(String[] args) {
//        // 某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
//        // 2019-9-15 13:00:00
//        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
//        int hours = 13;
//        int minutes = 20;
//        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
//        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
//        // test:
////        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
////                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
////            System.err.println("测试失败!");
////        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
////                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
////            System.err.println("测试失败!");
////        }
//    }
//
//    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
//        System.out.println(bj);
//        System.out.println(bj.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime());
//        System.out.println("=================");
//        return bj.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime().plusHours(h).plusMinutes(m);
//    }

    public static void main(String[] args) {
        long ts = 1574208900000L;
        System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts, Locale.US, "America/New_York"));
    }

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
