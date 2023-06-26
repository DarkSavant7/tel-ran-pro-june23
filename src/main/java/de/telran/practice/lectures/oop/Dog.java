package de.telran.practice.lectures.oop;

public class Dog extends Animal {

  public Dog(String name, String color) {
    super(name, color, "dog");
    System.out.println("Bird born");
  }

  @Override
  public void voice() {
    System.out.printf("%s dog %s barks%n", color, name);
  }
}
