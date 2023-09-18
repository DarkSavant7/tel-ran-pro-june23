package de.telran.practice.lectures.generics;

public class Orange extends Fruit {

  public Orange(double weight) {
    super(weight);
  }

  public void print() {
    System.out.println("Orange: " + this.getClass().getSimpleName() + "; weight=" + weight);
  }
}
