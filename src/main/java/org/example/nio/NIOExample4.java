package org.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.SneakyThrows;

public class NIOExample4 {

  @SneakyThrows
  public static void main(String[] args) {
    usingExists();
    usingIsTheSameFile();
  }

  public static void usingExists() {
    System.out.println("---exists---");
    Path file = Paths.get("src/main/resources/nio/example4/cities.txt");
    boolean exists = Files.exists(file);
    System.out.println(exists);

    Path dir = Paths.get("src/main/resources/nio/example4");
    exists = Files.exists(dir);
    System.out.println(exists);
  }

  public static void usingIsTheSameFile() throws IOException {
    System.out.println("---isSameFile---");
    Path path = Paths.get("src/main/resources/nio/example4/cities.txt");

    Path file = Paths.get("src/main/resources/nio/example4/cities.txt");

    System.out.println(Files.isSameFile(path, file));
  }

}
