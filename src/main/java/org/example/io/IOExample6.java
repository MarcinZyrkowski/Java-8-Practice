package org.example.io;

import java.io.Console;

public class IOExample6 {

  // to run this feature you need to make the Console class available
  // run it by following:
  // java absolute_path_to_java_class.java

  public static void main(String[] args) {
    Console console = System.console();
    if (console != null) {
      System.out.println("enter your input:");
      String userInput = console.readLine();
      console.writer().println("You entered the following: " + userInput);
      // console.writer().println() is not visible because it is not flushed
      // to change it uncomment the following:
      // console.flush();
      System.out.println("You entered, sout: " + userInput);
    } else {
      throw new RuntimeException("no console available");
    }
  }

}
