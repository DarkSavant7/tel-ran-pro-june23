package de.telran.practice.lectures.oop.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionsExample {

  public static void main(String[] args) {
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
    strings.forEach(CollectionsExample::doSomething);
  }

  private static void doSomething(String s) {
    System.out.println(s);
  }
}
