package com.bkc.test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

public class Java8Time {
    public static void main(String[] args) {
        //timeZone
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        availableZoneIds.stream().sorted((v1, v2) -> v1.substring(0).compareTo(v2.substring(0)))
            .forEach(System.out::println);

        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
        ZoneId utc = ZoneId.of("UTC");
        System.out.println(shanghai.getRules());
        System.out.println(utc.getRules());


        //LocalTime
        LocalTime nowShanghai = LocalTime.now(shanghai);
        LocalTime nowUtc = LocalTime.now(utc);

        System.out.println(nowShanghai.isBefore(nowUtc));

        long hoursBetween = ChronoUnit.HOURS.between(nowShanghai, nowUtc);
        long minutesBetween = ChronoUnit.MINUTES.between(nowShanghai, nowUtc);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);


        LocalTime morning = LocalTime.of(8, 01, 01);

        LocalTime afternoon = LocalTime.of(20, 01, 01);
        System.out.println(morning.isAfter(afternoon));

        /*DateTimeFormatter chineseFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(
            Locale.CHINESE);

        LocalTime leetTime = LocalTime.parse("10:37",chineseFormatter);
        System.out.println(leetTime);*/

        //localDate
        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(now.plus(1, ChronoUnit.DAYS));
        System.out.println(now.minus(20, ChronoUnit.DAYS));

        LocalDate independenceDay = LocalDate.of(2017, 10, 11);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(independenceDay + "--" + dayOfWeek);


        LocalDateTime localDateTime = LocalDateTime.of(2017, 11, 10, 23, 59, 59);
        DayOfWeek dayOfWeek1 = localDateTime.getDayOfWeek();

        System.out.println(localDateTime + "--" + dayOfWeek);

        Month month = localDateTime.getMonth();
        System.out.println(month);

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

    }
}
