package org.example.functionalprogramming;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FunctionalProgrammingExample1 {

  public static void main(String[] args) {
  }

  static Supplier<String> provideString = () -> "my own string"; // method: .get()

  static Consumer<Person> printPerson = Person::printObj; // method: .accept(person)

  static BiConsumer<String, Integer> constructor = Person::new; // method: .accept(string, integer)

  static Predicate<String> is3Digit = s -> s.length() == 3; // method: .test(string)

  static BiPredicate<String, String> lengthComparator = (f, s) -> f.length() == s.length();
  // method: .test(string, string)

  static Function<String, Integer> stringToLength = (String s) -> s.length() + 5;

  static BiFunction<String, String, Integer> doubleStringsToLength = (f, s) -> f.length() + s.length();
  // method : .apply(string, string)

  static UnaryOperator<String> newName = name -> "tom";
  // method : .apply(string) the same as Function<String, String>


  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Person {

    private String name;
    private Integer age;

    public static String getInfo() {
      return "Person static class";
    }

    public static void printObj(Person person) {
      System.out.println(person);
    }
  }

}
