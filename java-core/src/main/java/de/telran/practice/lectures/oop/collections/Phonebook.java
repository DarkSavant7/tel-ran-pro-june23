package de.telran.practice.lectures.oop.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * Создайте класс телефонного справочника, который хранит имена и номера телефонов,
 * привязанные к имени.
 * У одного контакта может быть несколько телефонов
 * Реализовать хранение контактов
 * метод add для добавления записей
 * метод get для получения набора номеров по имени
 */
public class Phonebook {

  private final Map<String, Set<String>> entries = new TreeMap<>();

  public void add(String name, String phone) {
//    Set<String> existing = entries.get(name);
//    if (existing == null) {
//      entries.put(name, new HashSet<>(Set.of(phone)));
//    } else {
//      existing.add(phone);
//    }
    var existing = entries.computeIfAbsent(name, key -> new HashSet<>());
    existing.add(phone);
//    entries.computeIfAbsent(name, new Function<String, Set<String>>() {
//      @Override
//      public Set<String> apply(String s) {
//        return new HashSet<>();
//      }
//    })
  }

  public Set<String> get(String name) {
    return entries.getOrDefault(name, Collections.emptySet());
  }

}
