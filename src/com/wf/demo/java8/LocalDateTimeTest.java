package com.wf.demo.java8;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Set;

/**
 * @author wf
 * @create 2020-06-04 22:13
 * @desc
 **/
public class LocalDateTimeTest {
    @Test
    public void test5() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test4() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);

        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with);

        LocalDateTime with1 = now.with(temporal -> {
            LocalDateTime ldt = (LocalDateTime) temporal;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });
        System.out.println(with1);
    }
    @Test
    public void test3() {
        LocalDate of = LocalDate.of(2020, 05, 20);
        LocalDate now = LocalDate.now();

        Period between = Period.between(of, now);
        System.out.println(between);

        System.out.println(between.getYears());
        System.out.println(between.getDays());
    }

    @Test
    public void test2() {
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime of = LocalDateTime.of(2020, 06, 06, 12, 12, 12);
        System.out.println(of);

        LocalDateTime localDateTime1 = of.plusYears(1);
        System.out.println(localDateTime1);
    }
}
