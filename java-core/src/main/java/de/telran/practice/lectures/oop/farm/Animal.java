package de.telran.practice.lectures.oop.farm;

public abstract class Animal {

  protected String name;
  protected AnimalColor color;
  protected String type;

  public Animal(String name, String color, String type) {
    this();
    this.name = name;
    this.color = AnimalColor.getByNameIgnoreCase(color);
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

  public String getName() {
    return name;
  }

  public AnimalColor getColor() {
    return color;
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", color=" + color +
        ", type='" + type + '\'' +
        '}';
  }
}
