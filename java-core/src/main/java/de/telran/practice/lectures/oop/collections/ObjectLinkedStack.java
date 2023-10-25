package de.telran.practice.lectures.oop.collections;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ObjectLinkedStack {

  private Node first;
  private int size;

  public ObjectLinkedStack() {
    this.size = 0;
  }

  public void push(Object element) {
    if (first == null) {
      first = new Node(element, null);
    } else {
      Node node = new Node(element, first);
      this.first = node;
    }
    size++;
  }

  public Object pop() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    Node result = first;
    this.first = result.next;
    size--;
    return result.element;
  }

  public int size() {
    return size;
  }

  static class Node {
    Object element;
    Node next;

    public Node(Object element, Node next) {
      this.element = element;
      this.next = next;
    }
  }
}
