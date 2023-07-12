package de.telran.practice.lectures.oop.enums;

public enum Operator {
  SUM {
    @Override
    public int perform(int a, int b) {
      return a + b;
    }
  },
  MULTIPLY {
    @Override
    public int perform(int a, int b) {
      return a * b;
    }
  };

  public abstract int perform(int a, int b);
}
