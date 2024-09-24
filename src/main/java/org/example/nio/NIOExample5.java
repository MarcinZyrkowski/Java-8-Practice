package org.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    copyingFilesWithIoAndIo2();
    deleteIfCopyFilewWithIoAndIo2Exist();
//    moveFile();
    moveFileBack();
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

  public static void copyingFilesWithIoAndIo2() {
    try (
        InputStream is = new FileInputStream("src/main/java/org/example/nio/dir/source.txt");
        OutputStream out = new FileOutputStream("src/main/java/org/example/nio/dir2/output.txt")) {

      // copy stream data to file
      Files.copy(is, Paths.get("src/main/java/org/example/nio/dir2/file-output.txt"));

      // copy file data to stream
      Files.copy(Paths.get("src/main/java/org/example/nio/dir/original.txt"), out);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void deleteIfCopyFilewWithIoAndIo2Exist() throws IOException {
    Files.deleteIfExists(Paths.get("src/main/java/org/example/nio/dir2/file-output.txt"));
    Files.deleteIfExists(Paths.get("src/main/java/org/example/nio/dir2/output.txt"));
  }

  public static void moveFile() {
    try {
      Files.move(Paths.get("src/main/java/org/example/nio/dir/fileToBeMoved.txt"),
          Paths.get("src/main/java/org/example/nio/dir2/fileToBeMoved.txt"));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void moveFileBack() {
    try {
      Files.move(Paths.get("src/main/java/org/example/nio/dir2/fileToBeMoved.txt"),
          Paths.get("src/main/java/org/example/nio/dir/fileToBeMoved.txt"));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
