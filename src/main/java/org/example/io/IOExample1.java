package org.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import lombok.SneakyThrows;

public class IOExample1 {

  @SneakyThrows
  public static void main(String[] args) {
    // if there is ambiguous path like: ...resources/io which could be applied to main/resource or test/resource
    // then we should use filePathFromRepoRoot
    String filePathFromRepoRoot = "src/main/resources/io/example1/namesList.txt";

    printFileData(filePathFromRepoRoot);
  }

  private static void printFileData(String pathName) throws FileNotFoundException {
    File file = new File(pathName);
    if (file.exists()) {
      System.out.println("Absolute path: " + file.getAbsolutePath());
      System.out.println("Is Directory: " + file.isDirectory());
      System.out.println("Parent path: " + file.getParent());
      System.out.println("File size: " + file.length());
      System.out.println("File lastModified:" + file.lastModified());
    } else {
      throw new FileNotFoundException("Didn't find file with provided path: " + pathName);
    }
  }

}
