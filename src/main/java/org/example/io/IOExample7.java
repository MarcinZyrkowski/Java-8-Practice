package org.example.io;

import java.io.Console;

public class IOExample7 {

  // to run this feature you need to make the Console class available
  // run it by following:
  // java absolute_path_to_java_class.java

  public static void main(String[] args) {
    Console console = System.console();
    if (console != null) {
      console.writer().println("WelcomeX");
      console.flush();
      console.format("Welcome = format");
      console.writer().println();
      console.printf("printf from console");
    } else {
      throw new RuntimeException("no console available");
    }
  }

}
