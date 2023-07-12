package de.telran.practice.lectures.oop.enums;

public class Test {

  public static void main(String[] args) {
//    DayOfMonth day = DayOfMonth.WEDNESDAY;
//    System.out.println(day);
//    System.out.println(day.name());
//    System.out.println(day.ordinal());
//    System.out.println(day.getNumber());
//
//    for (DayOfMonth d : DayOfMonth.values()) {
//      System.out.println(d);
//    }

//    DayOfMonth day = DayOfMonth.getByNumber(12);
//    System.out.println(day);

//    try {
//      day = DayOfMonth.getByNumber(999);
//    } catch (IllegalArgumentException e) {
//      e.printStackTrace();
//    }
//    day = DayOfMonth.getByNumber(999);

    Operator oper = Operator.MULTIPLY;

    System.out.println(oper.perform(22, 11));
    oper = Operator.SUM;
    System.out.println(oper.perform(22, 11));
  }

}
