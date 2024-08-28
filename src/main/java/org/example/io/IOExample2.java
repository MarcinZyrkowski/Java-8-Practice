package org.example.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOExample2 {

  public static void main(String[] args) {
    String repoRootPath = "src/main/resources/io/example2/";

    long pwTime = printWriterExecutionTime(repoRootPath);
    System.out.println("Print Writer time: " + pwTime);

    long bwTime = bufferedFileWriterExecutionTime(repoRootPath);
    System.out.println("Buffered Writer time: " + bwTime);

    System.out.println("pw time - bw time > 0 ::::: " + (pwTime - bwTime));
  }

  private static long printWriterExecutionTime(String repoRootPath) {
    long startTime = System.nanoTime();
    saveDataUsingPrintWriter(repoRootPath);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  private static long bufferedFileWriterExecutionTime(String repoRootPath) {
    long startTime = System.nanoTime();
    saveDataUsingBufferedWriter(repoRootPath);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }


  private static void saveDataUsingPrintWriter(String path) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(path + "output.txt"))) {
      writer.println("Hello, World!");
      writer.printf("Number: 42");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void saveDataUsingBufferedWriter(String path) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "output.txt"))) {
      writer.write("Hello, World!");
      writer.newLine();
      writer.write("Number: 42");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
