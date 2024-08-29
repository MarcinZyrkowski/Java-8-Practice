package org.example.io;

import java.io.Console;

public class IOExample6 {

  public static void main(String[] args) {

    Console console = System.console();
    if (console != null) {
      String userInput = console.readLine();
      console.writer().println("You entered the following:");
    }
  }

}
