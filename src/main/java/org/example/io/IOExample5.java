package org.example.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOExample5 {

  public static void main(String[] args) {
    File source = new File("src/main/resources/io/example5/Zoo.txt");
    usingPrintWriter(source);
  }

  public static void usingPrintWriter(File file) {
    try(PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(file)
        )
    )) {
      out.print("Today's weather is: ");
      out.println("Sunny");
      out.print("Today's temperature at the zoo is: ");
      out.print(1/3.0);
      out.println('C');
      out.format("It has rained 10.12 inches this year");
      out.println();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
