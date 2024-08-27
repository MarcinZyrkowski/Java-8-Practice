package org.example.datestimelocalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Locale;
import java.util.ResourceBundle;

public class DatesTimeLocalization {

  public static void main(String[] args) throws ParseException {
    usingPeriod();
    usingDuration();
    gettingDefaultLocale();
    usingResouceBundleProperties();
    usingResourceBundleClass();
    numberFormatting();
  }

  private static void numberFormatting() throws ParseException {
    int numerator = 100000;
    int denominator = 3;
    double result = (double) numerator / denominator;

    // number formats
    // us format
    NumberFormat us = NumberFormat.getNumberInstance(Locale.US);
    System.out.println("us: " + us.format(result));

    // germany format
    NumberFormat de = NumberFormat.getNumberInstance(Locale.GERMANY);
    System.out.println("de: " + de.format(result));

    // french canada format
    NumberFormat ca = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
    System.out.println("ca: " + ca.format(result));

    // currency format
    double price = 48;
    NumberFormat usPrice = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.println("us price: " + usPrice.format(price)); // $48.00

    // parsing
    String amount = "$92,807.99";
    NumberFormat cf = NumberFormat.getCurrencyInstance();
    double value = (Double) cf.parse(amount);
    System.out.println(value); // 92807.99
  }

  private static void usingResourceBundleClass() {
    // using class bundle
    // allows not only strings
    Locale uk = new Locale("en", "UK");
    ResourceBundle rb = ResourceBundle.getBundle("org.example.datestimelocalization.javaBundle.Zoo", uk);
    System.out.println(rb.getString("hello"));
    System.out.println(rb.getString("open"));
  }

  private static void usingResouceBundleProperties() {
    // using resource bundle properties file
    Locale france = new Locale("fr", "FR");
    ResourceBundle rb = ResourceBundle.getBundle("datestimelocalization.Zoo", france);
    System.out.println(rb.getString("hello"));
    System.out.println(rb.getString("open"));
  }

  private static void gettingDefaultLocale() {
    // printing default locale
    System.out.println("Default locale: " + Locale.getDefault());
  }

  private static void usingDuration() {
    LocalTime time = LocalTime.now();
    // we can put nanos, millis, seconds, minutes, hours, days
    System.out.println(addDuration(time, Duration.ofHours(1)));
  }

  private static void usingPeriod() {
    LocalDate date = LocalDate.now();
    // we can put any period here e.g. days, months, weeks, years
    System.out.println(addPeriod(date, Period.ofDays(1)));
  }

  public static LocalDate addPeriod(LocalDate date, Period period) {
    return date.plus(period);
  }

  public static LocalTime addDuration(LocalTime time, Duration duration) {
    return time.plus(duration);
  }

}

