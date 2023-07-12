package de.telran.practice.lectures.oop;

import de.telran.practice.lectures.oop.farm.Animal;
import de.telran.practice.lectures.oop.farm.Bird;
import de.telran.practice.lectures.oop.farm.Cat;
import de.telran.practice.lectures.oop.farm.Dog;
import de.telran.practice.lectures.oop.farm.Parrot;
import de.telran.practice.lectures.oop.farm.Snake;
import java.util.Arrays;
import java.util.Comparator;

public class InterfaceTest {

  public static void main(String[] args) {
//    doSomething1();
    //......

//    ConcatenatingImpl someObj = new ConcatenatingImpl();
//    someObj.sayMyName("Alex");
//
//    System.out.println(Doing.SOME_VALUE);
//
//    Doing.doSomethingStatic();

    Animal[] animals = {
        new Cat("Barsik", "Black"),
        new Dog("Bobik", "Red"),
        new Bird("Chizhik", "Grey"),
        new Cat("Murzik", "White"),
        new Bird("Tuco", "Yellow"),
        new Bird("Null", "Red"),
        new Snake("Kaa", "Green"),
        new Parrot("Kesha", "Blue")
    };

//    Arrays.sort(animals, new Comparator<Animal>() {
//      @Override
//      public int compare(Animal o1, Animal o2) {
////        return o1.getName().compareTo(o2.getName());
////        return o2.getName().compareTo(o1.getName());
//        return o1.getName().length() - o2.getName().length();
//      }
//    });

//    Arrays.sort(animals,
//(Animal o1, Animal o2) -> {
//        return o1.getName().length() - o2.getName().length();
//      }
//    );

//    Arrays.sort(animals,
//        (animal1, animal2) -> animal1.getName().length() - animal2.getName().length()   );

    Arrays.sort(animals, Comparator.comparingInt(animal -> animal.getName().length()));
    System.out.println(Arrays.toString(animals));
  }

  private static void doSomething1() {
    doSomething2();
  }

  private static void doSomething2() {
    doSomething3();
  }

  private static void doSomething3() {
    Farmer farmer = new Farmer();
    Moving farmer1 = new Farmer();
    Moving[] movings = {
        new Farmer(),
        new Car(),
        () -> System.out.println("Lmbda move"),
        new Plane(),
        new Moving() {
          @Override
          public void move() {
            System.out.println("Anon moving");
          }
        },
        () -> System.out.println("Anon moving"),
        () -> System.out.println("Anon moving")


    };

    for (Moving moving : movings) {
      moving.move();
      if (Math.random() * 100 > 50) {
        throw new RuntimeException();
      }
    }
  }
}
