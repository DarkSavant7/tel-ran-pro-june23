package de.telran.practice.lectures.oop.maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EqualCharsetFinder {

  /**
   * Сгруппируйте слова с одинаковым набором символов
   * <p>
   * Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым
   * уникальным набором символов. вход: String words[] = {"student", "students", "dog", "god",
   * "cat", "act", "flow", "wolf"};
   * <p>
   * выход: cat, act, dog, god, flow, wolf
   */

  public static void main(String[] args) {
    String[] words = {"student",
        "students",
        "dog",
        "god",
        "cat",
        "act",
        "flow",
        "good",
        "ogd",
        "dgo",
        "borg",
        "bark",
        "karb",
        "low",
        "slow",
        "owl",
        "wolf"};

//    System.out.println(getAnagrams("god", words));
//    System.out.println(findAllAnagramsInArray(words));
    System.out.println(findAllAnagramsInArrayMoreOptimal(words));
    System.out.println();
    var values = findAllAnagramsInArrayMoreOptimal(words).values();
    System.out.println(values);
  }

  static Map<String, Set<String>> findAllAnagramsInArrayMoreOptimal(String[] arr) {
    Map<String, Set<String>> map = new TreeMap<>();
    for (String s : arr) {
      var characters = s.toCharArray();
      Arrays.sort(characters);
      var set = map.computeIfAbsent(new String(characters),
          key -> new TreeSet<>());
      set.add(s);
    }
    return map;
  }

  static Map<String, Set<String>> findAllAnagramsInArray(String[] arr) {
    Map<String, Set<String>> result = new TreeMap<>();
    for (String s : arr) {
      result.put(s, getAnagrams(s, arr));
    }
    return result;
  }

  static Set<String> getAnagrams(String key, String[] arr) {
    char[] keyChars = key.toCharArray();
    Arrays.sort(keyChars);

    Set<String> result = new TreeSet<>();
    for (String s : arr) {
      char[] searchChars = s.toCharArray();
      Arrays.sort(searchChars);
      if (Arrays.equals(keyChars, searchChars)) {
        result.add(s);
      }
    }
    return result;
  }
}
