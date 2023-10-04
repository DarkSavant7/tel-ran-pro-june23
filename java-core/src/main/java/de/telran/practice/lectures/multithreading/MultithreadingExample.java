package de.telran.practice.lectures.multithreading;

public class MultithreadingExample {

  /**
   * Создать массив float c большим размером, например 100_000_000
   * заполнить массив единицами
   * и прогнать каждый элемент массива через обработку:
   * элемент это arr[i], i - это индекс элемента в массиве
   * arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0))
   *
   *Засечь время выполнения.
   *
   * Создать другой метод, который будет делать то же самое, но
   * в 2х потоках и также замерить время и в конце сравнить оба массива
   */

  public static void main(String[] args) {

  }
}
