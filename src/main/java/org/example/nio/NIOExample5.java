package org.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.SneakyThrows;

public class NIOExample5 {

  @SneakyThrows
  public static void main(String[] args) {
    createSingleDir();
    createMultipleDirs();
    deleteDir();
    deleteDirs();
    copy();
    deleteIfCopyExist();
  }

  public static void createSingleDir() throws IOException {
    Files.createDirectory(Paths.get("src/main/java/org/example/nio/dir/singleDir"));
  }

  public static void createMultipleDirs() throws IOException {
    Files.createDirectories(Paths.get("src/main/java/org/example/nio/dir/multiple/dirs"));
  }

  public static void deleteDir() throws IOException {
    Files.delete(Paths.get("src/main/java/org/example/nio/dir/singleDir"));
  }

  public static void deleteDirs() throws IOException {
    Files.delete(Paths.get("src/main/java/org/example/nio/dir/multiple/dirs"));
    Files.delete(Paths.get("src/main/java/org/example/nio/dir/multiple"));
  }

  public static void copy() throws IOException {
    Files.copy(Paths.get("src/main/java/org/example/nio/dir/original.txt"),
        Paths.get("src/main/java/org/example/nio/dir2/copy.txt"));
  }

  public static void deleteIfCopyExist() throws IOException {
    Files.deleteIfExists(Paths.get("src/main/java/org/example/nio/dir2/copy.txt"));
  }


}
