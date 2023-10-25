package de.telran.practice.lectures.oop.collections;

public class MyArrayDeque implements MyDeque {

  // предполагается запилить массив в 20 элементов
  private Integer[] elements;
  private int headIndex;
  private int tailIndex;
  private int size;
  private float growthRate;
  private static final int DEFAULT_CAPACITY = 20;
  private static final float DEFAULT_GROWTH_RATE = 2;

  public MyArrayDeque() {
    elements = new Integer[DEFAULT_CAPACITY];
    headIndex = tailIndex = elements.length / 2;
    this.growthRate = DEFAULT_GROWTH_RATE;
  }

  public MyArrayDeque(float growthRate) {
    elements = new Integer[DEFAULT_CAPACITY];
    headIndex = tailIndex = elements.length / 2;
    this.growthRate = growthRate;
  }

  private boolean needToGrow() {
    return headIndex == 0 || tailIndex == elements.length - 1;
  }

  private void grow() {
    //todo checks
    int newSize = (int) (elements.length * growthRate);
    Integer[] newElements = new Integer[newSize];
    int newHeadIndex = newSize / 2 - size / 2;
    System.arraycopy(this.elements, headIndex, newElements, newHeadIndex, size);
    this.elements = newElements;
    this.headIndex = newHeadIndex;
    this.tailIndex = headIndex + size;
  }

  @Override
  public void addToHead(Integer element) {
    if (needToGrow()) {
      grow();
    }

    if (!isEmpty()) {
      headIndex--;
    }
    elements[headIndex] = element;
    size++;
  }

  @Override
  public void addToTail(Integer element) {
    if (!isEmpty()) {
      tailIndex++;
    }
    elements[tailIndex] = element;
    size++;

  }

  @Override
  public Integer removeHead() {
    if (isEmpty()) {
      System.out.println("Deque empty, cannot remove");
      return null;
    } else {
      Integer auxilia = elements[headIndex];
      elements[headIndex] = null;
      headIndex++;
      size--;
      return auxilia;
    }
  }

  @Override
  public Integer removeTail() {
    if (isEmpty()) {
      System.out.println("Deque empty, cannot remove");
      return null;
    } else {
      Integer auxilia = elements[tailIndex];
      elements[tailIndex] = null;
      tailIndex--;
      size--;
      return auxilia;
    }
  }

  @Override
  public Integer peekHead() {
    if (isEmpty()) {
      System.out.println("Deque empty, cannot peek");
      return null;
    } else {
      return elements[headIndex];
    }
  }

  @Override
  public Integer peekTail() {
    if (isEmpty()) {
      System.out.println("Deque empty, cannot peek");
      return null;
    } else {
      return elements[tailIndex];
    }
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public Integer getByIndex(int index) {
    Integer tmp = null;
    if (headIndex + index <= tailIndex) {
      tmp = elements[headIndex + index];
    } else {
      System.out.println("Index out of bounds, values will be cycled");
      tmp = headIndex + index - tailIndex;
      return getByIndex(tmp);
    }
    return tmp;
  }

  @Override
  public boolean contains(Integer element) {
    for (int i = headIndex; i <= tailIndex; i++) {
      if (elements[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  public String toString() {
    if (isEmpty()) {
      return "[]";
    }
    StringBuilder builder = new StringBuilder("[");
    for (int i = headIndex; i <= tailIndex; i++) {
      builder.append(elements[i]).append(", ");
    }
    builder.setLength(builder.length() - 2);
    builder.append("]");
    return builder.toString();
  }

}
