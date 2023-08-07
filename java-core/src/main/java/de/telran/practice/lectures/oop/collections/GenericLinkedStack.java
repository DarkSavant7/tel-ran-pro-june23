package de.telran.practice.lectures.oop.collections;

import java.util.NoSuchElementException;

public class GenericLinkedStack<E> {

  private Node<E> first;
  private int size;

  public GenericLinkedStack() {
    this.size = 0;
  }

  public void push(E element) {
    if (first == null) {
      first = new Node<>(element, null);
    } else {
      this.first = new Node<>(element, first);
    }
    size++;
  }

  public E pop() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    Node<E> result = first;
    this.first = result.next;
    size--;
    return result.element;
  }

  public int size() {
    return size;
  }

  static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }
  }
}
