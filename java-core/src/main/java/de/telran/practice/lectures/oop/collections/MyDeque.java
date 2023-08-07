package de.telran.practice.lectures.oop.collections;

public interface MyDeque {

  void addToHead(Integer element);

  void addToTail(Integer element);

  Integer removeHead();

  Integer removeTail();

  Integer peekHead();

  Integer peekTail();

  boolean isEmpty();

  Integer getByIndex(int index);

  boolean contains(Integer element);

  int size();
}
