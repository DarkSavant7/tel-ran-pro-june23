package de.telran.practice.lectures.oop.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создайте класс Range, который будет включать диапазон целых чисел От и до (from, to), которые
 * можно задать в конструкторе. Реализуйте интерфейс Iterable<Integer> в этом классе (соответственно
 * Iterator<Integer> для этого класса Объект этого класса должен выдавать последовательность целых
 * чисел в заданном диапазоне с шагом 1 Кто хочет сложнее с заданным шагом.
 * <p>
 * Такой код должен работать: Range range = new Range(-10, 20);
 * <p>
 * for (Integer i : range) { System.out.print(i); }
 */
public class Range implements Iterable<Integer> {

  private int from;
  private int to;

  public Range(int from, int to) {
    if (to < from) {
      this.to = from;
      this.from = to;
    } else {
      this.from = from;
      this.to = to;
    }

  }

  @Override
  public Iterator<Integer> iterator() {
    return new RangeIterator(this);
  }

  static class RangeIterator implements Iterator<Integer> {

    private final Range range;
    private int pointer;

    public RangeIterator(Range range) {
      this.range = range;
      this.pointer = range.from;
    }

    @Override
    public boolean hasNext() {
      return pointer < range.to;
    }

    @Override
    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return pointer++;
    }
  }
}
