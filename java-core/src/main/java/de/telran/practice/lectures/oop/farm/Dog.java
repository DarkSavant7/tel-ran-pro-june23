package de.telran.practice.lectures.oop.farm;

public class Dog extends Animal {

  public Dog(String name, String color) {
    super(name, color, "dog");
    System.out.println("Bird born");
  }

  @Override
  public void voice() {
    System.out.printf("%s dog %s barks%n", color, name);
  }

  @Override
  public String toString() {
    return "Dog{" +
        "name='" + name + '\'' +
        ", color=" + color +
        ", type='" + type + '\'' +
        '}';
  }
}
