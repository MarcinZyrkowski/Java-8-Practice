package org.example.nio;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.SneakyThrows;

public class NIOExample1 {

  @SneakyThrows
  public static void main(String[] args) {
    gettingPath();
  }

  private static void gettingPath() throws URISyntaxException {
    // first way
    Path usingGet = Paths.get("src/main/resources/nio/example1/rivers.txt");

    // second way, URI throws exception
    Path usingURI = Paths.get(new URI("/absolute_path_should_be_here"));

    // third way
    Path usingFileSystems = FileSystems.getDefault().getPath("src/main/resources/nio/example1/rivers.txt");
  }

}
