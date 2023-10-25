package de.telran.practice.lectures.testing;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

  private Calculator calculator;


  @BeforeAll
  static void beforeAll() {
    System.out.println("GLOBAL INIT");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("GLOBAL CLOSE");
  }

  @BeforeEach
  void init() {
    System.out.println("INIT test method");
    calculator = new Calculator();
  }

  @AfterEach
  void close() {
    System.out.println("CLOSE test method");
  }

  @Test
  void add() {
    int a = 5;
    int b = 4;
    int expected = 9;
    var result = calculator.add(a, b);
    assertEquals(expected, result);
  }

  @Test
  void sub() {
    assertEquals(8, calculator.sub(10, 2));
  }

  @Test
  void mul() {
    assertEquals(20, calculator.mul(10, 2));
    assertEquals(22, calculator.mul(11, 2));
    assertEquals(30, calculator.mul(10, 3));
    assertEquals(4, calculator.mul(2, 2));
    assertEquals(8, calculator.mul(4, 2));
    assertEquals(121, calculator.mul(11, 11));
  }

  @Test
  void div() {
  }

  @Test
  void mulMass() {
    assertAll(
        () -> assertEquals(20, calculator.mul(10, 2)),
        () -> assertEquals(22, calculator.mul(11, 2)),
        () -> assertEquals(30, calculator.mul(10, 3)),
        () -> assertEquals(4, calculator.mul(2, 2)),
        () -> assertEquals(8, calculator.mul(4, 2)),
        () -> assertEquals(121, calculator.mul(11, 11))
    );

  }


  //  @CsvSource({
//      "4, 2, 2",
//      "10, 4, 2",
//      "12, 2, 6",
//      "16, 4, 4"
//  })
//  @CsvFileSource(files = {"test-files/test1.csv", "test-files/test2.csv"})
  @MethodSource("generator")
  @ParameterizedTest
  void divMass(int a, int b, int expected) {
    var result = calculator.div(a, b);
    assertEquals(expected, result);
  }

  public static Stream<Arguments> generator() {
    int count = 1000;
    List<Arguments> args = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      int a = (int) (Math.random() * count);
      int b = (int) (Math.random() * count) + 1;
      int result = a / b;
      if (Math.random() * 20 > 19) {
        args.add(Arguments.of(a, b, (int) (Math.random() * 100)));
      } else {
        args.add(Arguments.of(a, b, result));
      }

    }
    return args.stream();
  }
}