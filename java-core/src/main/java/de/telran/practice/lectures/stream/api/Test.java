package de.telran.practice.lectures.stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
//    firstExample();
//    secondExample();
//    simpleStreamApiExample();

//    streamApiForStringList();

//    filterWithoutStream();
    List<String> strings = List.of("January", "February", "March", "April", "May", "June", "July",
        "August");

    Boolean containsMarch = strings.stream()
        .anyMatch(s -> s.contains("arc"));

    boolean allContainLetterA = strings.stream()
        .allMatch(s -> s.contains("a"));

    boolean noneContainsQ = strings.stream()
        .noneMatch(s -> s.contains("q"));

    boolean noneLongerThanTenSymbols = strings.stream()
        .noneMatch(s -> s.length() > 10);

    System.out.println(containsMarch);
    System.out.println(allContainLetterA);
    System.out.println(noneContainsQ);
    System.out.println(noneLongerThanTenSymbols);

    Optional<String> fiveString = strings.stream()
        .filter(s -> s.length() == 5)
        .findAny();

  String result =  fiveString.orElse("DEFAULT");
    System.out.println(result);

    strings.removeIf(s -> s.startsWith("J"));

  }

  private static void filterWithoutStream() {
    List<String> strings = List.of("January", "February", "March", "April", "May", "June", "July",
        "August");
    List<String> filtered = new ArrayList<>();

    for (String str : strings) {
      if (str.contains("a") && str.endsWith("ry")) {
        filtered.add(str);
      }
    }

//    filtered.replaceAll(s -> s + " month");
    for (int i = 0; i < filtered.size(); i++) {
      String newValue = filtered.get(i) + " month";
      filtered.set(i, newValue);
    }
    System.out.println(filtered);
  }

  private static void streamApiForStringList() {
    List<String> strings = List.of("January", "February", "March", "April", "May", "June", "July",
        "August");
    List<String> filtered = strings.stream()
        .filter(str -> str.contains("a"))
        .filter(str -> str.endsWith("ry"))
        .map(str -> str + " month")
        .toList();

    System.out.println(strings);

    System.out.println();
    System.out.println(filtered);
  }

  private static void simpleStreamApiExample() {
    String issuer = "CN=cncncnc, O=org-data, ST=12, SOME=some-data";
    String[] arr = issuer.split(", ");
    Map<String, String> map = Arrays.stream(arr)
        .map(string -> string.split("="))
        .collect(
            Collectors.toMap(subArr -> subArr[0], subArr -> subArr[1])
//            Collectors.toMap(new Function<String[], String>() {
//              @Override
//              public String apply(String[] strings) {
//                return strings[0];
//              }
//            }, new Function<String[], String>() {
//              @Override
//              public String apply(String[] strings) {
//                return strings[1];
//              }
//            })
        );

//    System.out.println(map);
    map.forEach((k, v) -> System.out.printf("Key: %s, value: %s%n", k, v));
  }

  private static void secondExample() {
    printFromInterface(str -> System.out.println(str), "Hello world");

    printFromInterfaceWithTwoArgs((str1, str2) -> System.out.println(str1 + " " + str2), "Hello",
        "world!");
  }

  static void printFromInterface(OneArgumentFunctionalInterface lambda, String s) {
    lambda.print(s);
  }

  static void printFromInterfaceWithTwoArgs(TwoArgumentFunctionalInterface lambda, String s,
      String s2) {
    lambda.print(s, s2);
  }

  private static void firstExample() {
    Flying[] flyings = {
        new Balloon(),
        new Bird(),
        new Plane(),
        new Flying() {
          private String someString;

          public void doSomething() {

          }

          @Override
          public void fly() {
            System.out.println("Anonymous fly");
          }
        },
        new Flying() {
          @Override
          public void fly() {
            System.out.println("Anonymous fly");
          }
        },
        () -> System.out.println("Lambda fly")
    };

    for (Flying flying : flyings) {
      flying.fly();
      System.out.println(flying.getClass().getName());
    }
  }


}
