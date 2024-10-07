package org.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import lombok.SneakyThrows;

public class NIOExample6 {

  @SneakyThrows
  public static void main(String[] args) {
    readAttributes();
  }

  public static void readAttributes() throws IOException {
    Path path = Paths.get("src/main/resources/nio/example6/colors.txt");

    BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);

    System.out.println("Is path a directory? :" + data.isDirectory());
    System.out.println("Is path a regular file? :" + data.isRegularFile());
    System.out.println("Is path a symbolic link? :" + data.isSymbolicLink());
    System.out.println("Path not a file, directory, nor symbolic link? :" + data.isOther());
    System.out.println("Size (in bytes) :" + data.size());
    System.out.println("Creations date/time :" + data.creationTime());
    System.out.println("Last modified date/time :" + data.lastModifiedTime());
    System.out.println("Last accessed date/time :" + data.lastAccessTime());
    System.out.println("Unique file identifier (if available) " + data.fileKey());
  }

}
