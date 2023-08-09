package de.telran.practice.lectures.oop.maps;

import java.util.TreeMap;

public class TreeMapExample {

  public static void main(String[] args) {

//    TreeMap<MyClass, Integer> map = new TreeMap<>(Comparator.comparing(o -> o.word));
    TreeMap<MyClass, Integer> map = new TreeMap<>();

    map.put(new MyClass("One"), 1);

    System.out.println(map);
  }

  static class MyClass implements Comparable<MyClass> {
    private String word;

    public MyClass(String word) {
      this.word = word;
    }

    public String getWord() {
      return word;
    }

    public void setWord(String word) {
      this.word = word;
    }

    @Override
    public String toString() {
      return "MyClass{" +
          "word='" + word + '\'' +
          '}';
    }

    @Override
    public int compareTo(MyClass other) {
      return this.word.compareTo(other.word);
    }
  }
}
