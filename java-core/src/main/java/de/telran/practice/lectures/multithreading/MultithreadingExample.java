package de.telran.practice.lectures.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public static void main(String[] args) {
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
