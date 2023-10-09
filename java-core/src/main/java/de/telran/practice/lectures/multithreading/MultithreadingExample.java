package de.telran.practice.lectures.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MultithreadingExample {

  /**
   * Создать массив float c большим размером, например 100_000_000 заполнить массив единицами и
   * прогнать каждый элемент массива через обработку: элемент это arr[i], i - это индекс элемента в
   * массиве arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) *
   * Math.cos(0.4f + i / 2.0))
   * <p>
   * Засечь время выполнения.
   * <p>
   * Создать другой метод, который будет делать то же самое, но в 2х потоках и также замерить время
   * и в конце сравнить оба массива
   */
  private static final int SIZE = 100_000_000;
  private static final Object mon = new Object();
  private static volatile int flag = 0;

  public static void main(String[] args) throws InterruptedException {
//    runnableExample();
//    callableExample();

//    CompletableFuture

//    threadCancel();

    new Thread(MultithreadingExample::printHello).start();
    new Thread(MultithreadingExample::printWorld).start();
    new Thread(MultithreadingExample::printSign).start();
  }

  static void printHello() {
    try {
      synchronized (mon) {
        for (int i = 0; i < 5; i++) {
          while (flag != 0) {
//            MultithreadingExample.class.wait();
//            this.wait();
            mon.wait();
          }
          System.out.print("Hello");
          flag = 1;
          mon.notifyAll();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static void printWorld() {
    try {
      synchronized (mon) {
        for (int i = 0; i < 5; i++) {
          while (flag != 1) {
            mon.wait();
          }
          System.out.print(" world");
          flag = 2;
          mon.notifyAll();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static void printSign() {
    try {
      synchronized (mon) {
        for (int i = 0; i < 5; i++) {
          while (flag != 2) {
            mon.wait();
          }
          System.out.println("!");
          flag = 0;
          mon.notifyAll();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void threadCancel() throws InterruptedException {
    var future = new FutureTask<>(MultithreadingExample::longLastingLoop);
    new Thread(future).start();

    try {
      var result = future.get(4, TimeUnit.SECONDS);
      System.out.println(result);
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      future.cancel(true);
      e.printStackTrace();
    }
  }

  static String longLastingLoop() {
    int iteration = 0;
    while (!Thread.currentThread().isInterrupted()) {
      try {
        Thread.sleep(3000);
        System.out.println(iteration++);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
    return "ready";
  }

  private static void callableExample() throws InterruptedException {
    //    var command = new Callable<String>() {
//
//      @Override
//      public String call() throws Exception {
//        return "Hello";
//      }
//    };
//    var future = new FutureTask<>(command);
//    var future = new FutureTask<>(() -> "Hello!");
//    var future = new FutureTask<>(() -> {
//      var result = "Hello!";
//      System.out.println(result);
//      return result;
//    });
    var future = new FutureTask<>(MultithreadingExample::longOperation);
    new Thread(future).start();

    try {
      System.out.println(future.get(1, TimeUnit.SECONDS));
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      future.cancel(true);
      e.printStackTrace();
    }
  }

  static String longOperation() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "RESULT";
  }


  static String throwError() {
    throw new RuntimeException();
  }

  private static void runnableExample() throws InterruptedException {
    //    testArrayProcessing();
    var tError = new Thread(MultithreadingExample::throwSomething);
    doSomething();
    tError.start();
    var t1 = new Thread(MultithreadingExample::doSomething);
    t1.start();
    var t2 = new Thread(MultithreadingExample::doSomething);
    t2.start();
    var t3 = new Thread(MultithreadingExample::doSomething);
    t3.run();
    tError.join();
    System.out.println("FINISH");
  }

  static void doSomething() {
    System.out.println("Some operation from thread " + Thread.currentThread().getName());
  }

  static void throwSomething() {
    throw new RuntimeException("AAAAAAAAAAA");
  }

  private static void testArrayProcessing() {
    float[] example = oneThreadTest();
    var datas = multiTest(1, 16, 1);

    for (float[] data : datas) {
      System.out.println("Arrays equals: " + Arrays.equals(example, data));
    }
  }


  private static List<float[]> multiTest(int minThread, int maxThread, int step) {
    List<float[]> list = new ArrayList<>();
    for (int i = minThread; i <= maxThread; i += step) {
      float[] data = new float[SIZE];
      Arrays.fill(data, 1.0f);
      var start = System.currentTimeMillis();
      multiProcessing(data, i);
      var time = System.currentTimeMillis() - start;
      System.out.printf("Multi method with %d threads  time: %d%n", i, time);
      list.add(data);
    }
    return list;

  }


  private static float[] oneThreadTest() {
    float[] data1 = new float[SIZE];
    Arrays.fill(data1, 1.0f);

    var start = System.currentTimeMillis();
    calculate(data1);
    var time = System.currentTimeMillis() - start;

    System.out.println("One thread method time: " + time);
    return data1;
  }

  static void multiProcessing(float[] arr, int threads) {
    try {
      List<Thread> list = new ArrayList<>(threads);
      for (int i = 0; i < threads; i++) {
        int j = i;
        var thread = new Thread(() -> sequentialMethod(arr, threads, j));
        thread.start();
        list.add(thread);
      }
      for (Thread thread : list) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static void sequentialMethod(float[] data, int offset, int startIndex) {
    if (offset < 1) {
      offset = 1;
    }
    if (startIndex < 0) {
      startIndex = 0;
    }

    for (int i = startIndex; i < data.length; i += offset) {
      var currentValue = data[i];
      data[i] = calculateValue(i, currentValue);
    }
  }

  static float calculateValue(int index, float value) {
    return (float) (value * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(
        0.4f + index / 2.0));
  }

  static void calculate(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(
          0.4f + i / 2.0));
    }
  }
}
