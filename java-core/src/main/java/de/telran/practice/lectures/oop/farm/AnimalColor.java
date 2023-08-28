package de.telran.practice.lectures.oop.farm;

public enum AnimalColor {

  BLACK,
  GREEN,
  WHITE,
  RED,
  YELLOW,
  GREY,
  BROWN,
  BLUE;

  public static AnimalColor getByNameIgnoreCase(String name) {
    for (AnimalColor value : values()) {
      if (value.name().equalsIgnoreCase(name)) {
        return value;
      }
    }

//    throw new IllegalArgumentException("No such color: " + name);
    return null;
  }
}
