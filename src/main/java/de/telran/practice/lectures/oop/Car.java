package de.telran.practice.lectures.oop;

import de.telran.practice.lectures.oop.farm.Animal;
import java.io.Serializable;

//public class Car extends Animal implements Moving, Cloneable, Serializable {
public class Car implements Moving {

  @Override
  public void move() {
    System.out.println("Car is driven");
  }
}
