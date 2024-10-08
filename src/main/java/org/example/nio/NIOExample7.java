package org.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample7 {

  public static void main(String[] args) {
    Path path = Paths.get("src/main/resources/nio/example7/country");

    System.out.println("travers");
    traverse(path);

    System.out.println("list dir content");
    listDir(path);

    Path us = Paths.get("src/main/resources/nio/example7/country/US.txt");
    System.out.println("show file content");
    printFileContent(us);
  }

  public static void traverse(Path path) {
    try {
      Files.walk(path)
          .filter(p -> p.toString().endsWith(".txt"))
          .forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void listDir(Path path) {
    try {
      Files.list(path)
          .filter(p -> !Files.isDirectory(p))
          .map(Path::toAbsolutePath)
          .forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void printFileContent(Path path) {
    try {
      Files.lines(path).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
