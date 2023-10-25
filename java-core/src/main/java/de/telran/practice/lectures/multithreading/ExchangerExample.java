package de.telran.practice.lectures.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExample {

  public static void main(String[] args) {
//    Class<Exchanger> exchangerClass = Exchanger.class;
//    Class<List> listClass = List.class;
    Exchanger<Item> exchanger = new Exchanger<>();
    Auto first = new Auto("First", exchanger,
        new ArrayList<>(List.of(new Item("Iron", 2), new Item("Laptop", 1), new Item("Phone", 1))));
    Auto second = new Auto("Second", exchanger,
        new ArrayList<>(List.of(new Item("Brush", 2), new Item("Headphones", 1), new Item("Battery", 1))));

//    List<String> list = new ArrayList<>();
//    list.of("kvfk", "kfkf");

    new Thread(first).start();
    new Thread(second).start();
  }

  static class Auto implements Runnable {

    private String name;
    private Exchanger<Item> exchanger;
    private List<Item> items;

    public Auto(String name, Exchanger<Item> exchanger, List<Item> items) {
      this.name = name;
      this.exchanger = exchanger;
      this.items = items;
    }

    @Override
    public void run() {
      try {
        System.out.printf("Auto %s with items: %s departs%n", name, items);
        Thread.sleep((long) (Math.random() * 2000));
        System.out.printf("Auto %s arrived to exchange point%n", name);
        var exchangeItem = items.get(0);
        System.out.printf("Auto %s gave item: %s%n", name, exchangeItem);
        Item received = exchanger.exchange(exchangeItem);
        System.out.printf("Auto %s received item: %s%n", name, received);
        items.set(0, received);
        Thread.sleep((long) (Math.random() * 2000));
        System.out.printf("Auto %s with items: %s finished%n", name, items);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Item {

    private String name;
    private int weigh;

    public Item(String name, int weigh) {
      this.name = name;
      this.weigh = weigh;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getWeigh() {
      return weigh;
    }

    public void setWeigh(int weigh) {
      this.weigh = weigh;
    }

    @Override
    public String toString() {
      return "Item{" +
          "name='" + name + '\'' +
          ", weigh='" + weigh + '\'' +
          '}';
    }
  }
}
