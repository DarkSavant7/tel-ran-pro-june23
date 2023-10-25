package de.telran.practice.lectures.stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {

  public static void main(String[] args) {
//    String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
//    printFrom2dArrayExcluding(array, "a", "d");
//    studentTask();

    int[] ints = new Random().ints(200).toArray();

    System.out.println(Arrays.toString(ints));
    System.out.println(
        Arrays.stream(ints)
            .average()
    );

    System.out.println(
        Arrays.stream(ints)
            .reduce((x, y) -> x + y)
//            .reduce(Integer::sum)
    );
    System.out.println(
        Arrays.stream(ints)
            .sum()
    );

    System.out.println(
        Arrays.stream(ints)
            .filter(x -> x % 15 == 0)
            .count()
    );

    System.out.println(
        Arrays.stream(ints)
            .filter(x -> x % 2 == 0)
            .count()
    );

    System.out.println(
        Arrays.stream(ints)
            .filter(x -> x % 2 != 0)
            .count()
    );

    System.out.println(
        Arrays.stream(ints)
            .map(x -> (int) Math.sqrt(x))
            .sum()
    );
    double avg = Arrays.stream(ints)
        .dropWhile(x -> x % 15 != 0)
        .filter(x -> x % 3 == 0)
        .mapToDouble(x ->  Math.pow(x, 2.0))
        .average().getAsDouble();

    System.out.println(
        avg
    );

    System.out.println(
        Arrays.toString(Arrays.stream(ints)
            .dropWhile(x -> x % 15 != 0)
            .filter(x -> x % 3 == 0)
            .mapToDouble(x -> Math.pow(x, 2.0))
            .filter(x -> x > avg)
            .toArray())
    );

  }

  /*
Студент записывает книги которые прочитал, задача вывести все прочитанные книги у всех студентов (в качестве
дополнения, применить фильтр на любую тему)
 */
  private static void studentTask() {
    Student student1 = new Student();
    student1.setName("Aleks");
    student1.addBook("Java 8 vs Java 19");
    student1.addBook("Spring Boot in Action");
    student1.addBook("Effective Java");
    student1.addBook("Book6");
    student1.addBook("Book7");
    student1.addBook("Book8");

    Student student2 = new Student();
    student2.setName("Thomas");
    student2.addBook("HTML introducing");
    student2.addBook("Effective Java");
    student2.addBook("Book2");
    student2.addBook("Book3");
    student2.addBook("Book4");
    student2.addBook("Book5");

    List<Student> list = new ArrayList<>();
    list.add(student1);
    list.add(student2);

    //Взять все книги всех студентов
    //Выкинуть из списка первые две
    //Оставить в списке не более 2х книг
    Set<String> books = list.stream()
        .flatMap(student -> student.getBooks().stream())
        .takeWhile(book -> !book.contains("HTML"))
        .sorted(Comparator.reverseOrder())
//        .skip(2)
//        .limit(2)
//        .filter(book -> book.contains("Java"))

        .collect(Collectors.toSet());

    System.out.println(books);

    books = list.stream()
        .flatMap(student -> student.getBooks().stream())
        .dropWhile(book -> !book.contains("HTML"))
        .collect(Collectors.toSet());

    System.out.println(books);
    Map<String, List<String>> result = list.stream()
        .flatMap(student -> {
          var studentBooks = student.getBooks().stream().toList();
          return studentBooks.stream()
              .map(book -> new Pair(student.getName(), book));
        })
        .filter(pair -> pair.getBook().contains("Java"))
        .collect(Collectors.toMap(Pair::getName,
            pair -> new ArrayList<>(List.of(pair.getBook())),
            (books1, books2) -> {
              books1.addAll(books2);
              return books1;
            }));

    System.out.println(result);
  }

  // Отфильтровать "a" (исключить из печати) и распечатать все символы.
  private static void printFrom2dArrayExcluding(String[][] arr, String... exclude) {
    Stream.of(arr)
//        .flatMap(subArray -> Stream.of(subArray))
        .flatMap(Stream::of)
        .filter(str -> !Set.of(exclude).contains(str))
        .forEach(System.out::print);
  }
}
