package de.telran.practice.lectures.oop.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
  public static void breadthFirstSearch(BinaryTree tree) {

    if (tree == null || tree.isEmpty()) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(tree.getRoot());

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      System.out.print(current.getValue() + " ");

      if (current.getLeft() != null) {
        queue.add(current.getLeft());
      }

      if (current.getRight() != null) {
        queue.add(current.getRight());
      }
    }
    System.out.println();
  }

  public static void depthInorder(AnotherBinaryTree tree) {

    if (tree == null || tree.isEmpty()) {
      return;
    }

    Stack<AnotherBinaryTree.Node> stack = new Stack<>();
    AnotherBinaryTree.Node current = tree.getRoot();

    while (current != null || !stack.isEmpty()) {

      while (current != null) {
        stack.push(current);
        current = current.getLeft();
      }

      current = stack.pop();

      System.out.print(current.getValue() + " ");

      current = current.getRight();
    }
    System.out.println();
  }

  public static void depthPreorder(BinaryTree tree) {

    if (tree == null || tree.isEmpty()) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(tree.getRoot());

    while (!stack.empty()) {

      Node curr = stack.pop();

      System.out.print(curr.getValue() + " ");

      if (curr.getRight() != null) {
        stack.push(curr.getRight());
      }

      if (curr.getLeft() != null) {
        stack.push(curr.getLeft());
      }
    }
    System.out.println();
  }

  public static void depthPostorder(BinaryTree tree) {

    if (tree == null || tree.isEmpty()) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(tree.getRoot());

    Stack<String> out = new Stack<>();

    while (!stack.empty()) {
      Node curr = stack.pop();
      out.push(curr.getValue());

      if (curr.getLeft() != null) {
        stack.push(curr.getLeft());
      }

      if (curr.getRight() != null) {
        stack.push(curr.getRight());
      }
    }

    while (!out.empty()) {
      System.out.print(out.pop() + " ");
    }
  }

}
