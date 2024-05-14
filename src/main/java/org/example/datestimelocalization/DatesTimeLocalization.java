package org.example.datestimelocalization;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DatesTimeLocalization {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        // we can put any period here e.g. days, months, weeks, years
        System.out.println(addPeriod(date, Period.ofDays(1)));

        LocalTime time = LocalTime.now();
        // we can put nanos, millis, seconds, minutes, hours, days
        System.out.println(addDuration(time, Duration.ofHours(1)));
    }

    public static LocalDate addPeriod(LocalDate date, Period period) {
        return date.plus(period);
    }

    public static LocalTime addDuration(LocalTime time, Duration duration) {
        return time.plus(duration);
    }

}

