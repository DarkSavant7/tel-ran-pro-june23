package de.telran.practice.lectures.oop;

public abstract class Animal {

  protected String name;
  protected String color;
  protected String type;

  public Animal(String name, String color, String type) {
    this();
    this.name = name;
    this.color = color;
    this.type = type;
  }

  private Animal() {
    super();
    System.out.println("Animal born");
  }

  public void move() {
    System.out.printf("%s %s %s walk on paws%n", color, type, name);
  }

  public abstract void voice();

}
