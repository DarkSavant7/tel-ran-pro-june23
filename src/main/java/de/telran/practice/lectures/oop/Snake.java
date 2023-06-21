package de.telran.practice.lectures.oop;

public class Snake extends Animal {

  public Snake(String name, String color) {
    super(name, color, "snake");
    System.out.println("Snake born");
  }

  @Override
  public void voice() {
    System.out.printf("%s snake %s sshhhhhshs%n", color, name);
  }

  @Override
  public void move() {
    System.out.printf("%s snake %s crawls%n", color, name);
  }
}
