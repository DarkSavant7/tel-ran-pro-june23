package de.telran.practice.lectures.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

  private Calculator calculator;
  private CalculatorService service;

  @BeforeEach
  void init() {
//    calculator = Mockito.mock(Calculator.class);
//    calculator = Mockito.spy(Calculator.class);
    var calc = new Calculator();
    calculator = spy(calc);
    service = new CalculatorService(calculator);
  }

  @Test
  void add() {
//    when(calculator.add(4, 5)).thenReturn(14);
//    when(calculator.add(50, 50)).thenReturn(100);
//    when(calculator.add(anyInt(), anyInt())).thenReturn(14, 100);
//    doReturn(14).when(calculator).add(5, 2);
//    doNothing();
//    doThrow();
//    doAnswer();
    when(calculator.add(anyInt(), eq(5))).thenReturn(14, 100);
    assertEquals(14, service.add(4, 5));
    assertEquals(100, service.add(50, 50));
//    verify(calculator).add(5, 5);
    verify(calculator, times(1)).add(4, 5);
    verify(calculator, times(0)).add(5, 5);
  }
}