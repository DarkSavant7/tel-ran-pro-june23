package de.telran.practice.lectures.oop;

public enum DayOfMonth {
  SUNDAY(10),
  MONDAY(25),
  TUESDAY(-10),
  WEDNESDAY(12),
  THURSDAY(99),
  FRIDAY(14),
  SATURDAY(100);

  private int number;

  DayOfMonth(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return name() + " " + number;
  }
}
