package org.example.datestimelocalization;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Locale;
import java.util.ResourceBundle;

public class DatesTimeLocalization {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        // we can put any period here e.g. days, months, weeks, years
        System.out.println(addPeriod(date, Period.ofDays(1)));

        LocalTime time = LocalTime.now();
        // we can put nanos, millis, seconds, minutes, hours, days
        System.out.println(addDuration(time, Duration.ofHours(1)));

        // printing default locale
        System.out.println("Default locale: " + Locale.getDefault());

        // using resource bundle properties file
        Locale france = new Locale("fr", "FR");
        ResourceBundle rb = ResourceBundle.getBundle("datestimelocalization.Zoo", france);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));

        // using class bundle
        // allows not only strings
        Locale uk = new Locale("en", "UK");
        rb = ResourceBundle.getBundle("org.example.datestimelocalization.javaBundle.Zoo_en", uk);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }

    public static LocalDate addPeriod(LocalDate date, Period period) {
        return date.plus(period);
    }

    public static LocalTime addDuration(LocalTime time, Duration duration) {
        return time.plus(duration);
    }

}

