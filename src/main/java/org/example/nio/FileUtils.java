package org.example.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

  public static void readFile(File file) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}


