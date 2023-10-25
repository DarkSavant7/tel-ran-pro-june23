package de.telran.practice.lectures.oop;

public class Farmer implements Moving {

  public Farmer() {
    super();
  }

  @Override
  public void move() {
    System.out.println("Farmer is walking on their feet");
  }
}
