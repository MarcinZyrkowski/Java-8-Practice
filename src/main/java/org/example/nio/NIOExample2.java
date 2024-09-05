package org.example.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample2 {

  public static void main(String[] args) {
    viewingThePath();
  }

  private static void viewingThePath() {
    Path path = Paths.get("src/main/resources/nio/example2/cities.txt");

    // string representation of the entire path
    System.out.println(path.toString());

    // using name count
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println("element i=" + i + " is: " + path.getName(i));
    }
  }

}
