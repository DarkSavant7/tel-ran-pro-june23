package de.telran.practice.lectures.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericsExample {

  public static void main(String[] args) {
    List<Apple> apples = List.of(new Apple(1d), new Apple(2d), new Apple(3d));
    printFruits(apples);
    List<Orange> oranges = List.of(new Orange(1d), new Orange(2d), new Orange(3d));
    printFruits(oranges);

//    List<? extends Fruit> producerFruit = oranges;
//    producerFruit.forEach(Fruit::print);
//    producerFruit.add(new Orange(1.0));

//    List<? super Orange> consumerFruit = new ArrayList<>(oranges);
//    consumerFruit.add(new Orange(0.5));
//    consumerFruit.add(new Orange(0.5));
//
//    consumerFruit.forEach(fruit -> fruit.print());

    List<Fruit> fruit = new ArrayList<>(
        List.of(new Apple(1d), new Apple(2d), new Apple(3d), new Orange(0.2)));

//    fruit.addAll(apples);

    Collections.copy(fruit, apples);
//    Collections.copy(apples, fruit);

    doSomething(apples);
    doSomething(fruit);
    List<Object> objects = List.of("sbfbdsfbd", 10, new Apple(1.0));
//    doSomething(objects);

    List list = new ArrayList();
    list.add("mnkxmvfkmvdfk");
    list.add(new Apple(0.2));
    list.add(1);

    FruitBox box = new FruitBox();
    box.add(new Apple(1.0));
//    box.add("ew Apple(1.0)");

    fruit.add(new Fruit(9.99));

    fruit.forEach(Fruit::print);
  }


  static void printFruits(List<? extends Fruit> fruits) {
    fruits.forEach(Fruit::print);
  }

  static void doSomething(List<? super Apple> list) {
    list.forEach(System.out::println);
    //TestNg
//    list.forEach(fruit -> fruit.print());
//    list.forEach(fruit -> {
//      if (fruit instanceof Fruit f) {
//        f.print();
//      }
//    });
    //.....
  }

}
