package de.telran.practice.lectures.oop;

public class InterfaceTest {

  public static void main(String[] args) {
    Farmer farmer = new Farmer();
    Moving farmer1 = new Farmer();

    Moving[] movings = {
        new Farmer(),
        new Car(),
        () -> System.out.println("Lmbda move"),
        new Plane(),
        new Moving() {
          @Override
          public void move() {
            System.out.println("Anon moving");
          }
        },
        () -> System.out.println("Anon moving"),
        () -> System.out.println("Anon moving")


    };

    for (Moving moving : movings) {
      moving.move();
    }
  }
}
