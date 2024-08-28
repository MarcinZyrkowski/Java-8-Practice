package org.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

public class IOExample4 {

  @SneakyThrows
  public static void main(String[] args) {
    List<Animal> animals = new ArrayList<>();
    animals.add(new Animal("Tommy Tiger", 5, 'T'));
    animals.add(new Animal("Peter Penguin", 8, 'P'));

    File dataFile = new File("src/main/resources/io/example4/animalData");
    createAnimalFile(animals, dataFile);
    System.out.println(getAnimals(dataFile));
  }

  public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
    List<Animal> animals = new ArrayList<>();

    try (
        ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream(dataFile)))) {

      while (true) {
        Object object = in.readObject();
        if (object instanceof Animal) {
          animals.add((Animal) object);
        }
      }
    } catch (EOFException e) {
      // we are expecting EOFException for end of the file
    }
    return animals;
  }

  public static void createAnimalFile(List<Animal> animals, File dataFile) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(dataFile)))) {
      for (Animal animal : animals) {
        out.writeObject(animal);
      }
    }
  }

  @Data
  @AllArgsConstructor
  public static class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private char type;
  }

}
