package com.lffblk.tutorials.java8.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by lffblk on 28.05.2017.
 */
public class DateTimeTester {
    public static void main(String[] args) {
        localDateTimeTester();
        zonedDateTimeTester();
        periodDurationTester();
        chronoUnitsEnumTester();
        temporalAdjustersTester();
    }

    private static void localDateTimeTester() {
        System.out.println("\nLocal Date-Time API tester");
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current time: " + currentTime);

        LocalDate currentDate = currentTime.toLocalDate();
        System.out.println("Current Date: " + currentDate);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month + ", day: " + day + ", seconds: " + seconds);

        // Change current time
        LocalDateTime dateTime = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("Date: " + dateTime);

        // 12 december 2014
        LocalDate date = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("12 december 2014: " + date);

        // 22 hour 15 minutes
        LocalTime time = LocalTime.of(22, 15);
        System.out.println("22 hour 15 minutes: " + time);

        // parse a string
        LocalTime parsed = LocalTime.parse("20:15:30");
        System.out.println("Parsed time: " + parsed);
    }

    private static void zonedDateTimeTester() {
        System.out.println("\nZoned Date-Time API tester");
        // Get the current date and time
        ZonedDateTime currentTime = ZonedDateTime.now();
        System.out.println("Current time: " + currentTime);

        // parse a string
        ZonedDateTime parsed = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("Parsed time: " + parsed);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("Current Zone: " + currentZone);
    }

    private static void periodDurationTester() {
        System.out.println("\nPeriod/Duration tester");
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        LocalDate afterMonth = currentDate.plus(1, ChronoUnit.MONTHS);
        Period period = Period.between(currentDate, afterMonth);

        System.out.println("Current Date: " + currentDate);
        System.out.println("Date after month: " + afterMonth);
        System.out.println("Period: " + period + ", months: " + period.getMonths());

        LocalTime currentTime = LocalTime.now();
        Duration duration = Duration.ofHours(2);
        LocalTime after2Hours = currentTime.plus(duration);

        System.out.println("\nCurrent Time: " + currentTime);
        System.out.println("After 2 hours: " + after2Hours);
        System.out.println("Duration: " + duration);
    }

    private static void chronoUnitsEnumTester() {
        System.out.println("\nChronoUnits enum tester");
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current day: " + today);

        // add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);

        // add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);

        // add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);

        // add 10 year, 9 month and 8 days to the current date
        LocalDate resultDate = today
                .plus(10, ChronoUnit.YEARS)
                .plus(9, ChronoUnit.MONTHS)
                .plus(8, ChronoUnit.DAYS);
        System.out.println("Result date: " + resultDate);
    }

    private static void temporalAdjustersTester() {
        System.out.println("\nTemporal Adjusters tester");
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // get the next tuesday
        LocalDate nextTuesday = currentDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday: " + nextTuesday);

        // get the second saturday of next month
        LocalDate firstDayOfNextMonth = LocalDate.of(currentDate.getYear(), currentDate.getMonth().plus(1), 1);
        System.out.println("First day of next months: " + firstDayOfNextMonth);
        LocalDate secondSaturday = firstDayOfNextMonth
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second Saturday of next month: " + secondSaturday);
    }
}
