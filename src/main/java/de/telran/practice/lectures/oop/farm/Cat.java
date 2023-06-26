package de.telran.practice.lectures.oop.farm;

public class Cat extends Animal {

  public Cat(String name, String color) {
    super(name, color, "cat");
    System.out.println("Cat born");
  }

  @Override
  public void voice() {
    System.out.printf("%s cat %s MEAWW%n", color, name);
  }
}
