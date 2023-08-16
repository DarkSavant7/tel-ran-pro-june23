package de.telran.practice.lectures.oop.graph;

import de.telran.practice.lectures.oop.graph.WeightedGraph.WeightedEdge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
  public static void main(String[] args) {
//    firstGraphTest();
    List<WeightedGraph.WeightedEdge> edges = new ArrayList<>();
    edges.add(new WeightedEdge(0, 1, 4));
    edges.add(new WeightedEdge(0, 2, 11));
    edges.add(new WeightedEdge(0, 3, 3));
    edges.add(new WeightedEdge(1, 0, 65));
    edges.add(new WeightedEdge(2, 1, 4));
    edges.add(new WeightedEdge(2, 3, 23));
    edges.add(new WeightedEdge(2, 0, 8));
  }

  private static void firstGraphTest() {
    Set<Edge> edges = new HashSet<>();

    edges.add(new Edge(0,3));
    edges.add(new Edge(1,2));
    edges.add(new Edge(1,6));
    edges.add(new Edge(2,1));
    edges.add(new Edge(2,3));
    edges.add(new Edge(2,4));
    edges.add(new Edge(3,0));
    edges.add(new Edge(3,2));
    edges.add(new Edge(4,2));
    edges.add(new Edge(4,5));
    edges.add(new Edge(5,4));
    edges.add(new Edge(6,1));

    Graph graph = new Graph(edges);
    System.out.println();
    GraphUtil.printGraph(graph);
  }
}
