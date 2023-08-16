package de.telran.practice.lectures.oop.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WeightedGraph {

  private Map<Integer, List<Node>> interconnectionTable = new HashMap<>();

  public WeightedGraph(List<WeightedEdge> edges) {
    for (WeightedEdge edge : edges) {
      interconnectionTable.putIfAbsent(edge.source, new ArrayList<>());
      interconnectionTable.putIfAbsent(edge.destination, new ArrayList<>());
    }
    for (WeightedEdge edge : edges) {
      interconnectionTable.get(edge.getSource())
          .add(new Node(edge.getDestination(), edge.getWeight()));
    }
  }

  public void removeVertex(int value) {
    interconnectionTable.remove(value);
    var connections = interconnectionTable.values();
    connections.forEach(c -> c.removeIf(node -> node.value == value));
  }

  public Map<Integer, List<Node>> getInterconnectionTable() {
    return interconnectionTable;
  }

  public void print() {

    interconnectionTable.forEach((k, v) -> System.out.printf("[ %s -->> %s ]%n", k, v));
//    int pointer = 0;
//    int size = interconnectionTable.size();
//    do {
//      for (Node node : interconnectionTable.get(pointer)) {
//        System.out.printf("[ %s -->> %s ]", pointer, node);
//      }
//      System.out.println();
//      pointer++;
//    } while (pointer < size);
  }

  public static class Node {

    private int value;
    private int weight;

    public Node(int value, int weight) {
      this.value = value;
      this.weight = weight;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "Node{" +
          "value=" + value +
          ", weight=" + weight +
          '}';
    }
  }

  public static class WeightedEdge {

    private int source;
    private int destination;
    private int weight;

    public WeightedEdge(int source, int destination, int weight) {
      if (source == destination) {
        throw new RuntimeException();
      }
      this.weight = weight;
      this.source = source;
      this.destination = destination;
    }

    public int getSource() {
      return source;
    }

    public void setSource(int source) {
      this.source = source;
    }

    public int getDestination() {
      return destination;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public void setDestination(int destination) {
      this.destination = destination;
    }

    @Override
    public String toString() {
      return String.format("Ribs from - %d, to - %d", source, destination);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof WeightedEdge that)) {
        return false;
      }
      return source == that.source && destination == that.destination && weight == that.weight;
    }

    @Override
    public int hashCode() {
      return Objects.hash(source, destination, weight);
    }
  }
}
