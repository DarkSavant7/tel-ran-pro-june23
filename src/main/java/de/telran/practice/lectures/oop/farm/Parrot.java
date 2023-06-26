package de.telran.practice.lectures.oop.farm;

public class Parrot extends Bird {

  public Parrot(String name, String color) {
    super(name, color);
    System.out.println("Parrot born");
  }

  public void speak() {
    System.out.printf("%s bird %s: 'Piastros'%n", color, name);
  }
}
