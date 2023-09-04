package de.telran.practice.lectures.stream.api;

public class GenericPairClass<K, V> {

  private final K key;
  private final V value;

  public GenericPairClass(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K key() {
    return key;
  }

  public V value() {
    return value;
  }
}
