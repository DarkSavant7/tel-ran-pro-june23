package de.telran.practice.lectures.oop;

import java.io.Serializable;

public class ConcatenatingImpl implements Serializable, Cloneable, Concatenating {

  @Override
  public void doSomething() {

  }

  @Override
  public void makeSomething() {

  }

  @Override
  public void createSomething() {

  }

  @Override
  public void move() {

  }

  @Override
  public String sayMyName(String name) {
    return Concatenating.super.sayMyName(name);
  }
}
