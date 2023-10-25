package de.telran.practice.lectures.oop.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class CollectionsExample {

  public static void main(String[] args) {
//    listExample();
//    iteratorExample();

//    ArrayList<String> arrayList = new ArrayList<>();
//    arrayList.ensureCapacity(100500);
//    arrayList.trimToSize();

    LinkedList<String> list = new LinkedList<>(List.of("One", "Two", "Three"));

//    System.arraycopy();
    list.addFirst("Zero");//offerFirst / push
    list.addLast("Four");//offer / offerLast
    System.out.println(list.getLast()); //peekLast
    System.out.println(list.getFirst()); //peek / peekFirst
    System.out.println(list.poll()); //remove /pollFirst / pop / removeFirst
    System.out.println(list.pollLast()); //removeLast

    System.out.println(list);
  }

  private static void iteratorExample() {
    String[] arr = {"March", "April", "May"};

    ArrayIterator iter = new ArrayIterator(arr);

    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

  private static void listExample() {
    //List, Map, Set
//    List<String> strings = new ArrayList<>();
    List<String> strings = new ArrayList<>(10);
//    List<String> strings = new ArrayList<>(Arrays.asList("SSSS", "SSSS"));
    List<String> list1 = Arrays.asList("ee", "dfcd", "sfdvfd");
    List<String> list2 = List.of("ee", "dfcd", "sfdvfd");
    List<String> list3 = Collections.emptyList();
    List<String> list4 = Collections.singletonList("SINGLE");
    List<String> list5 = Collections.unmodifiableList(strings);
    List<String> list6 = Collections.synchronizedList(strings);

    strings.add("One");
    strings.add("Two");
    strings.add("Three");
    System.out.println(strings);
    strings.add(0, "Zero");
    System.out.println(strings);
    strings.add("Three");
//    strings.add(null);
    System.out.println(strings);
    strings.addAll(List.of("Four", "Five"));
    System.out.println(strings.get(4));
//    strings.clear();
    System.out.println(strings.contains("One"));
    System.out.println(strings.contains("one"));
    System.out.println(strings.containsAll(List.of("One", "Three", "Zero")));
    System.out.println(strings.containsAll(List.of("One", "Three", "Zero", "Six")));

    System.out.println(strings.indexOf("Three"));
    System.out.println(strings.lastIndexOf("Three"));

//    System.out.println(strings.isEmpty());
//    System.out.println(strings.remove("Three"));
//    System.out.println(strings.remove("dfsbnjokdbgfsnjogsdbgf"));
//    System.out.println(strings.remove(0));
//    strings.removeAll(List.of("One", "Five", "Six", "Three"));
//    System.out.println(strings);

    strings.set(4, "Nine");
    System.out.println(strings);

//    strings.set(100, "Hundred");

//    strings.add("Five");
//    strings.retainAll(List.of("One", "Five"));
//    System.out.println(strings);
//    strings.replaceAll(new UnaryOperator<String>() {
//      @Override
//      public String apply(String s) {
//        return "NUMBER: " + s;
//      }
//    });

//    strings.replaceAll(s -> "Number: " + s);
//    System.out.println(strings);

//    strings.removeIf(new Predicate<String>() {
//      @Override
//      public boolean test(String s) {
//        return s.length() > 3;
//      }
//    });
//    strings.removeIf(string -> string.length() > 3);
//    System.out.println(strings);

//    for (int i = 0; i < strings.size(); i++) {
//      System.out.println(strings.get(i));
//    }
//
//    for (String string : strings) {
//      System.out.println(string);
//    }

//    strings.forEach(new Consumer<String>() {
//      @Override
//      public void accept(String s) {
//        System.out.println(s);
//      }
//    });

//    strings.forEach(string -> System.out.println(string));
//    strings.forEach(System.out::println);
//    strings.forEach(CollectionsExample::doSomething);

//    Iterator<String> iterator = strings.iterator();
//
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
////      iterator.remove();
//    }
//
//    System.out.println(strings);

//    for (String string : strings) {
//      strings.remove(string);
//    }

    ListIterator<String> iter = strings.listIterator();

    while (iter.hasNext()) {
      System.out.println(iter.next());

//      iter.previous();
    }
  }

  private static void doSomething(String s) {
    System.out.println(s);
  }

  static class ArrayIterator implements Iterator<String> {

    private final String[] array;
    private int pointer = -1;

    public ArrayIterator(String[] array) {
      this.array = array;
    }

    @Override
    public boolean hasNext() {
      return pointer + 1 < array.length;
    }

    @Override
    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return array[++pointer];
    }
  }
}
