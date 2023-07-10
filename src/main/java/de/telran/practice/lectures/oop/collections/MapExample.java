package de.telran.practice.lectures.oop.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class MapExample {

  public static void main(String[] args) {
//    Map<String, String> map = new HashMap<>();
//    dplicatesExample();

    Phonebook phonebook = new Phonebook();

    phonebook.add("Vasya", "1111111111");
    phonebook.add("Vasya", "1111111111");
    phonebook.add("Vasya", "12312312312");
    phonebook.add("Vasya", "123121232222222");
    phonebook.add("Petya", "222222");
    phonebook.add("Ira", "33333");
    phonebook.add("Petya", "44444");

    System.out.printf("Petya numbers: %s%n", phonebook.get("Petya"));
    System.out.printf("Ira numbers: %s%n", phonebook.get("Ira"));
    System.out.printf("Vasya numbers: %s%n", phonebook.get("Vasya"));
  }

  private static void dplicatesExample() {
    //    var entrySet = map.entrySet();
//    map.values();
//    map.keySet();
    var list = List.of("One", "Two", "Three", "One", "One", "Three", "Three", "Three");
    System.out.println(removeDuplicates(list));
    System.out.println(countWords(list));
  }

  //Метод, который принимает список строк, и возвращает его без дубликатов.

  public static List<String> removeDuplicates(List<String> source) {
    var set = new HashSet<>(source);
    return new ArrayList<>(set);
  }

  public static Map<String, Integer> countWords(List<String> list) {
    var resultMap = new HashMap<String, Integer>();

    for (String word : list) {
//      resultMap.put(word, resultMap.getOrDefault(word, 0) + 1);

      resultMap.merge(word, 1, Integer::sum);
//      resultMap.merge(word, 1, new BiFunction<Integer, Integer, Integer>() {
//        @Override
//        public Integer apply(Integer integer, Integer integer2) {
//          return integer + integer2;
//        }
//      });
    }
    return resultMap;
  }


}
