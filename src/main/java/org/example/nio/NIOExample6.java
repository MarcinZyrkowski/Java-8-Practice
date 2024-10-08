package org.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import lombok.SneakyThrows;

public class NIOExample6 {

  @SneakyThrows
  public static void main(String[] args) {
    Path path = Paths.get("src/main/resources/nio/example6/colors.txt");

    readAttributes(path);
    modifyAttributes(path);
  }

  public static void readAttributes(Path path) throws IOException {
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

  public static void modifyAttributes(Path path) throws IOException {
    BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);

    BasicFileAttributes data = view.readAttributes();

    FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);

    view.setTimes(lastModifiedTime, null, null);
  }

}
