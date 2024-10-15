package org.example.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOExample2 {

  public static void main(String[] args) {
    String rootPath = "src/main/resources/nio/example2/cities.txt";
    Path path = Paths.get(rootPath);

    System.out.println("===viewing the path===");
    viewingThePath(path);
    System.out.println("===accessing path components===");
    accessingPathComponents(path);
    System.out.println("===checking path type===");
    checkingPathType(path);
    System.out.println("===creating subpath===");
    creatingSubPath(path);
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
    System.out.println(path.toAbsolutePath().getRoot());
  }

  private static void checkingPathType(Path path) {
    System.out.println(path.isAbsolute());

    Path absPath = path.toAbsolutePath();
    System.out.println(absPath.isAbsolute());
    System.out.println(absPath.getRoot());
    System.out.println(absPath.toString());
  }

  private static void creatingSubPath(Path path) {
    // first index inclusive
    // last index exclusive
    System.out.println("Subpath from 0 to 3: " + path.subpath(0,3));
    System.out.println("Subpath from 3 to 6: " + path.subpath(3,6));
  }

}
