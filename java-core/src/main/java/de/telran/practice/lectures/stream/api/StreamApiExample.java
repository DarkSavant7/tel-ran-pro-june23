package de.telran.practice.lectures.stream.api;

import de.telran.practice.lectures.oop.farm.Animal;
import de.telran.practice.lectures.oop.farm.Bird;
import de.telran.practice.lectures.oop.farm.Cat;
import de.telran.practice.lectures.oop.farm.Dog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiExample {

  public static void main(String[] args) {
//    intStreamExample();
//    catsExample();
//    animalBoxExample();

    Set<AnimalBox<?>> boxes1 = Set.of(
        new AnimalBox<>(
            new Cat("Barsik", "White"),
            new Cat("Murzik", "Black"),
            new Cat("Murka", "Brown"),
            new Cat("Tom", "Grey"),
            new Cat(null, "Grey")
        ),
        new AnimalBox<>(
            new Dog("Barsik2", "White"),
            new Dog("Murzik2", "Black"),
            new Dog("Murka2", "Brown"),
            new Dog("Tom2", "Grey"),
            new Dog(null, "Grey")
        ),
        new AnimalBox<>(
            new Bird("Barsik3", "White"),
            new Bird("Murzik3", "Black"),
            new Bird("Murka3", "Brown"),
            new Bird("Tom", "Grey"),
            new Bird(null, "Grey")
        )
    );

    Set<AnimalBox<?>> boxes2 = Set.of(
        new AnimalBox<>(
            new Cat("Barsik", "White"),
            new Cat("Murzik", "Black"),
            new Cat("Murka", "Brown"),
            new Cat("Tom", "Grey"),
            new Cat(null, "Grey")
        ),
        new AnimalBox<>(
            new Dog("Barsik2", "White"),
            new Dog("Murzik2", "Black"),
            new Dog("Murka2", "Brown"),
            new Dog("Tom2", "Grey"),
            new Dog(null, "Grey")
        ),
        new AnimalBox<>(
            new Bird("Barsik3", "White"),
            new Bird("Murzik3", "Black"),
            new Bird("Murka3", "Brown"),
            new Bird("Tom", "Grey"),
            new Bird(null, "Grey")
        )
    );

    AnimalContainer container = new AnimalContainer(boxes1);
    AnimalContainer container2 = new AnimalContainer(boxes2);

    List<? extends Animal> animals = Set.of(container2, container).stream()
        .filter(Objects::nonNull)
        .flatMap(animalContainer -> animalContainer.boxes.stream())
        .flatMap(box -> box.animals.stream())
        .filter(animal -> animal.getName() != null)
        .toList();

    System.out.println(animals);
  }

  private static void animalBoxExample() {
    List<AnimalBox<?>> boxes = List.of(
        new AnimalBox<>(
            new Cat("Barsik", "White"),
            new Cat("Murzik", "Black"),
            new Cat("Murka", "Brown"),
            new Cat("Tom", "Grey"),
            new Cat(null, "Grey")
        ),
        new AnimalBox<>(
            new Dog("Barsik2", "White"),
            new Dog("Murzik2", "Black"),
            new Dog("Murka2", "Brown"),
            new Dog("Tom2", "Grey"),
            new Dog(null, "Grey")
        ),
        new AnimalBox<>(
            new Bird("Barsik3", "White"),
            new Bird("Murzik3", "Black"),
            new Bird("Murka3", "Brown"),
            new Bird("Tom", "Grey"),
            new Bird(null, "Grey")
        )
    );

    Map<String, ? extends Animal> map = boxes.stream()
        .flatMap(box -> box.animals.stream())
        .filter(animal -> animal.getName() != null)
        .collect(Collectors.toMap(Animal::getName, Function.identity(),
            (anima1, animal2) -> anima1));
//            (anima1, animal2) -> anima1.getAge() > animal2.getAge() ? anima1 : animal2;
    System.out.println(map);
  }

  private static void catsExample() {
    List<Cat> cats = List.of(
        new Cat("Barsik", "White"),
        new Cat("Murzik", "Black"),
        new Cat("Murka", "Brown"),
        new Cat("Tom", "Grey"),
        new Cat(null, "Grey")
    );

    Set<Dog> dogs = cats.stream()
        .filter(cat -> cat.getName() != null)
        .map(cat -> new Dog(cat.getName(), cat.getColor().name()))
        .collect(Collectors.toSet());

    System.out.println(dogs);
  }

  private static void intStreamExample() {
    int[] array = {32, 16, 54, 98, 7, 4, 5, 61, 2, 3};
    Arrays.stream(array)
//        .filter(element -> element % 2 == 0)
//        .filter(new IntPredicate() {
//          @Override
//          public boolean test(int element) {
//            return element % 2 == 0;
//          }
//        })
        .filter(element -> element % 2 == 0)
        .map(el -> el * 10)
        .filter(el -> el < 500)
//        .forEach(System.out::println);
//        .forEach(i -> System.out.println(i));
        .forEach(StreamApiExample::print);
  }

  private static void print(int number) {
    //.....
    System.out.println("Number: " + number);
  }

  public static class AnimalContainer {

    Set<AnimalBox<? extends Animal>> boxes;

    public AnimalContainer(Set<AnimalBox<? extends Animal>> boxes) {
      this.boxes = boxes;
    }

  }

  public static class AnimalBox<T extends Animal> {

    List<T> animals;

    public void add(T animal) {
      animals.add(animal);
    }

    public AnimalBox(Collection<T> animals) {
      this.animals = new ArrayList<>(animals);
    }

    public AnimalBox(T... animals) {
      this.animals = new ArrayList<>(Arrays.asList(animals));
    }

    public AnimalBox() {
      this.animals = new ArrayList<>();
    }

    public List<T> getAnimals() {
      return animals;
    }

    public void setAnimals(List<T> animals) {
      this.animals = animals;
    }
  }
}
