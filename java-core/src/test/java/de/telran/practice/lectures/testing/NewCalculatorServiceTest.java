package de.telran.practice.lectures.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NewCalculatorServiceTest {


  @Spy
//  @Mock
  private Calculator calculator;
  private CalculatorService service;

//  @BeforeEach
//  void init() {
//  }

  //  @BeforeAll
//  static void init() {
//    MockitoAnnotations.openMocks(NewCalculatorServiceTest.class);
//  }
  @Test
  void sub() {
//    MockitoAnnotations.openMocks(this);
//    calculator = mock(Calculator.class);
    service = new CalculatorService(calculator);
//    doReturn(99).doReturn(14).when(calculator).sub(anyInt(), anyInt());
//    doReturn(99).doReturn(14).when(calculator).sub(anyInt(), eq(100490));
//    doReturn(99).when(calculator).sub(100500, 100490);
    when(calculator.sub(100500, 100490)).thenReturn(99, 14);
    //2 types:
    //when(mock.doSomething(....)).then(.....) thenReturn thenThrow
    //do.. doThrow doReturn(value).when(mock).doSomething
    assertEquals(99, service.sub(100500, 100490));
    assertEquals(14, service.sub(100500, 100490));
    assertEquals(9, service.sub(100500, 100491));

    verify(calculator, times(2)).sub(100500, 100490);
    verify(calculator, times(1)).sub(100500, 100491);
    verify(calculator, timeout(200)).sub(100500, 100491);
    verify(calculator, times(0)).sub(3242, 12);
  }
}