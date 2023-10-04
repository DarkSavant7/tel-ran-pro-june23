package de.telran.practice.lectures.multithreading;

public class RaceConditionExample {

  private final Object mon = new Object();
  private final Object mon1 = new Object();
  private final Object mon2 = new Object();
  private final Object mon3 = new Object();

  public static void main(String[] args) throws InterruptedException {
    RaceConditionExample example = new RaceConditionExample();

    var t1 = new Thread(() -> example.multiIncrement(1000));
    var t2 = new Thread(() -> example.multiIncrement(1000));
    var t3 = new Thread(() -> example.multiIncrement(1000));

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();

    example.print();
  }

  private int a;
  private int b;
  private int c;

  public void multiIncrement(int count) {
    for (int i = 0; i < count; i++) {
      increment();
    }
  }

  public /*synchronized*/ void increment() {
//    Vector
    synchronized (mon) {
      a++;
      b++;
      c++;
    }
  }

  public /*synchronized*/ void incrementA() {
//    Vector
    synchronized (mon1) {
      a++;
    }
  }

  public /*synchronized*/ void incrementB() {
//    Vector
    synchronized (mon2) {
      b++;
    }
  }

  public /*synchronized*/ void incrementC() {
//    Vector
    synchronized (mon3) {
      c++;
    }
  }

  public /*synchronized*/ void decrement() {
    synchronized (mon1) {
//      mon.wait();
//      mon.notify();
      a--;
      b--;
      c--;
    }
  }

  public void print() {
    System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
  }
}
