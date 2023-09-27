package de.telran.practice.lectures.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RareCalculatorTest {

  private Calculator calculator;
  private int[] data;

  public RareCalculatorTest(int[] data) {
    this.data = data;
  }

  //  @BeforeAll
//  static void beforeAll() {
//    System.out.println("GLOBAL INIT");
//  }
//
//  @AfterAll
//  static void afterAll() {
//    System.out.println("GLOBAL CLOSE");
//  }

  @Parameterized.Parameters
  public static Collection<Object> data() {
    return List.of(
        new int[]{4, 2, 6},
        new int[]{10, 4, 14}
    );
  }

  @Before
  public void init() {
    System.out.println("INIT test method");
    calculator = new Calculator();
  }

  @After
  public void close() {
    System.out.println("CLOSE test method");
  }

  @Test
  public void add() {
    int a = data[0];
    int b = data[1];
    int expected = data[2];
    var result = calculator.add(a, b);
    assertEquals(expected, result);
  }

//  @Test
//  void sub() {
//    assertEquals(8, calculator.sub(10, 2));
//  }
//
//  @Test
//  void mul() {
//    assertEquals(20, calculator.mul(10, 2));
//    assertEquals(22, calculator.mul(11, 2));
//    assertEquals(30, calculator.mul(10, 3));
//    assertEquals(4, calculator.mul(2, 2));
//    assertEquals(8, calculator.mul(4, 2));
//    assertEquals(121, calculator.mul(11, 11));
//  }
//
//  @Test
//  void div() {
//  }
//
//  @Test
//  void mulMass() {
//    assertAll(
//        () -> assertEquals(20, calculator.mul(10, 2)),
//        () -> assertEquals(22, calculator.mul(11, 2)),
//        () -> assertEquals(30, calculator.mul(10, 3)),
//        () -> assertEquals(4, calculator.mul(2, 2)),
//        () -> assertEquals(8, calculator.mul(4, 2)),
//        () -> assertEquals(121, calculator.mul(11, 11))
//    );
//
//  }
//
//
//  //  @CsvSource({
////      "4, 2, 2",
////      "10, 4, 2",
////      "12, 2, 6",
////      "16, 4, 4"
////  })
////  @CsvFileSource(files = {"test-files/test1.csv", "test-files/test2.csv"})
//  @MethodSource("generator")
//  @ParameterizedTest
//  void divMass(int a, int b, int expected) {
//    var result = calculator.div(a, b);
//    assertEquals(expected, result);
//  }
//
//  public static Stream<Arguments> generator() {
//    int count = 1000;
//    List<Arguments> args = new ArrayList<>(count);
//    for (int i = 0; i < count; i++) {
//      int a = (int) (Math.random() * count);
//      int b = (int) (Math.random() * count) + 1;
//      int result = a / b;
//      if (Math.random() * 20 > 19) {
//        args.add(Arguments.of(a, b, (int) (Math.random() * 100)));
//      } else {
//        args.add(Arguments.of(a, b, result));
//      }
//
//    }
//    return args.stream();
//  }
}