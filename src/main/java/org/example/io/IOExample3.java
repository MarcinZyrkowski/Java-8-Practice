package org.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.SneakyThrows;

public class IOExample3 {

  @SneakyThrows
  public static void main(String[] args) {
    File source = new File("src/main/resources/io/example3/from.txt");
    File destination = new File("src/main/resources/io/example3/to.txt");

    copy(source, destination);
  }

  private static void copy(File source, File destination) throws IOException {
    try (
        InputStream in = new BufferedInputStream(new FileInputStream(source));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
      byte[] buffer = new byte[1024];
      int lenghtRead;
      while ((lenghtRead = in.read(buffer)) > 0) {
        out.write(buffer, 0, lenghtRead);
        out.flush();
      }
    }
  }

}
