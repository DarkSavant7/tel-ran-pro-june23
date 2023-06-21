package de.telran.practice.lectures.oop;

public class Bird extends Animal {

  public Bird(String name, String color) {
    super(name, color, "bird");
    System.out.println("Bird born");
  }
  @Override
  public void voice() {
    System.out.printf("%s bird %s Chik cheerick%n", color, name);
  }

  public void fly() {
    System.out.printf("%s bird %s flies%n", color, name);
  }

}
