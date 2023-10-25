package de.telran.practice.lectures.oop.graph;

import java.util.Objects;

public class Edge {
  private int source;
  private int destination;

  public Edge(int source, int destination) {
    if (source == destination) {
      throw new RuntimeException();
    }
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

  public void setDestination(int destination) {
    this.destination = destination;
  }

  @Override
  public String toString() {
    return  String.format("Ribs from - %d, to - %d", source ,destination);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Edge edge = (Edge) o;
    return source == edge.source && destination == edge.destination;
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, destination);
  }
}
