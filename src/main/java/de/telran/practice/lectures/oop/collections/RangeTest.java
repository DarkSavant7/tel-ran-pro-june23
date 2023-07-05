package de.telran.practice.lectures.oop.collections;

import java.util.Iterator;

public class RangeTest {

  public static void main(String[] args) {
//    Range range = new Range(-50, 50);
    Range range = new Range(999, 1024);

    Iterator<Integer> iter = range.iterator();

//    while (iter.hasNext()) {
//      System.out.println(iter.next());
//    }
//    for (i in 10..20)
    for (Integer integer : range) {
      System.out.print(integer + " ");
    }
  }
}
