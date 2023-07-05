package de.telran.practice.lectures.oop.collections;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    Spliterator<Integer> split = numbers.spliterator();

    Spliterator<Integer> split2 = split.trySplit();
    Spliterator<Integer> split3 = split.trySplit();
    Spliterator<Integer> split4 = split2.trySplit();

    while (split.tryAdvance(integer -> System.out.print(integer + " "))) {
    }
    System.out.println();

    while (split2.tryAdvance(integer -> System.out.print(integer + " "))) {
    }
    System.out.println();

    while (split3.tryAdvance(integer -> System.out.print(integer + " "))) {
    }
    System.out.println();

    while (split4.tryAdvance(integer -> System.out.print(integer + " "))) {
    }
    System.out.println();
  }
}
