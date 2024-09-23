package org.example.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.SneakyThrows;

public class NIOExample3 {

  // . A reference to the current directory
  // .. A reference to the parent of the current directory

  @SneakyThrows
  public static void main(String[] args) {
    usingRelativize();
    usingRelativizeWithAbsPath();
    usingResolve();
    usingResolveWithAbs();
    usingNormalize();
    usingToRealPath();
  }

  public static void usingRelativize() {
    System.out.println("relativize()");
    Path path1 = Paths.get("fish.txt");
    Path path2 = Paths.get("birds.txt");

    System.out.println(path1.relativize(path2));
    System.out.println(path2.relativize(path1));
  }

  public static void usingRelativizeWithAbsPath() {
    System.out.println("relativize() with abs");
    Path path3 = Paths.get("/habitat");
    Path path4 = Paths.get("/sanctuary/raven");

    System.out.println(path3.relativize(path4));
    System.out.println(path4.relativize(path3));
  }

  public static void usingResolve() {
    System.out.println("resolve()");
    Path path1 = Paths.get("/cats/../panther");
    Path path2 = Paths.get("food");
    System.out.println(path1.resolve(path2));
  }

  public static void usingResolveWithAbs() {
    System.out.println("resolve() with abs");
    Path path1 = Paths.get("/turkey/food");
    Path path2 = Paths.get("/tiger/cage");
    System.out.println(path1.resolve(path2));
  }

  public static void usingNormalize() {
    System.out.println("normalize()");
    Path path1 = Paths.get("/data");
    Path path2 = Paths.get("/user/home");

    Path relativePath = path1.relativize(path2);
    System.out.println(relativePath);

    System.out.println(path1.resolve(relativePath));

    System.out.println(path1.resolve(relativePath).normalize());
  }

  public static void usingToRealPath() throws IOException {
    System.out.println(Paths.get(".").toRealPath());
  }

}
