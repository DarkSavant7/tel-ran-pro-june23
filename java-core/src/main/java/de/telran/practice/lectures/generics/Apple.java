package de.telran.practice.lectures.generics;

public class Apple extends Fruit {

  public Apple(double weight) {
    super(weight);
  }

  public void print() {
    System.out.println("Apple: " + this.getClass().getSimpleName() + "; weight=" + weight);
  }
}
