package de.telran.practice.lectures.oop;

public class Test {

  public static void main(String[] args) {
    DayOfMonth day = DayOfMonth.WEDNESDAY;
    System.out.println(day);
    System.out.println(day.name());
    System.out.println(day.ordinal());
    System.out.println(day.getNumber());

    for (DayOfMonth d : DayOfMonth.values()) {
      System.out.println(d);
    }
  }

}
