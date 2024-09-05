package org.example.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample2 {

  public static void main(String[] args) {
    String rootPath = "src/main/resources/nio/example2/cities.txt";
    Path path = Paths.get(rootPath);

    viewingThePath(path);
    accessingPathComponents(path);
  }

  private static void viewingThePath(Path path) {
    // string representation of the entire path
    System.out.println(path.toString());

    // using name count
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println("element i=" + i + " is: " + path.getName(i));
    }
  }

  private static void accessingPathComponents(Path path) {
    Path fileName = path.getFileName();
    System.out.println(fileName);

    Path parent = path.getParent();
    System.out.println(parent);

    Path root = path.getRoot();
    System.out.println(root); // returns null because path is relative
  }

}
