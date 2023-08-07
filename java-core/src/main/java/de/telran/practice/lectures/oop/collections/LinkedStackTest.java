package de.telran.practice.lectures.oop.collections;

import de.telran.practice.lectures.oop.farm.Cat;

public class LinkedStackTest {

  public static void main(String[] args) {
//    stringStackExample();
//    objectStack();
//    sumStack();
    GenericLinkedStack<Integer> stack = new GenericLinkedStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
//    stack.push("1");

    int sum = 0;
    while (stack.size() > 0) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }

  private static void sumStack() {
    ObjectLinkedStack stack = new ObjectLinkedStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push("1");

    int sum = 0;
    while (stack.size() > 0) {
      Object element = stack.pop();
      if (element instanceof Integer i) {
        sum += i;
      }
    }

    System.out.println(sum);
  }

  private static void objectStack() {
    ObjectLinkedStack stack = new ObjectLinkedStack();

    stack.push("One");
    stack.push("Two");
    stack.push("Three");
    stack.push("Four");
    stack.push(100500);
    stack.push(new Cat("Bars", "black"));
    System.out.println(stack.size());

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.size());
//    System.out.println(stack.pop());
  }

  private static void stringStackExample() {
    LinkedStack stack = new LinkedStack();

    stack.push("One");
    stack.push("Two");
    stack.push("Three");
    stack.push("Four");
    System.out.println(stack.size());

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    System.out.println(stack.pop());
  }

}
