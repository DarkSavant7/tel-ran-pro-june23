package de.telran.practice.lectures.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * // Есть три потока.
 *     // 1 поток выводит в консоль пять раз букву А (без переноса строки)
 *     // 2 поток выводит в консоль пять раз букву В (без переноса строки)
 *     // 3 поток выводит в консоль пять раз букву С (без переноса строки)
 *     // Запустить потоки одновременно, но синхронизировать их таким образом,
 *     // чтобы получить вывод в консоль -> ABCABCABCABCABC
 *     // Результат должен выводиться моментально,
 *     // то есть sleep использовать нельзя.
 *     // Можно использовать любые знания, полученные на модуле.
 */
public class Task {
  private volatile char currentLetter = 'A';


  public static void main(String[] args) throws InterruptedException {
    Task task = new Task();

    ExecutorService service = Executors.newFixedThreadPool(3);
    service.execute(() -> task.printLetterCycle('A', 10));
    service.execute(() -> task.printLetterCycle('B', 10));
    service.execute(() -> task.printLetterCycle('C', 10));

    service.shutdown();
    service.awaitTermination(30, TimeUnit.SECONDS);
    System.out.println("FINISH");
  }

  private void printLetterCycle(char letter, int count) {
    for (int i = 0; i < count; i++) {
      printLetter(letter);
    }
  }

  private synchronized void printLetter(char letter) {
   try {
      while (currentLetter != letter) {
        this.wait();
      }
      if (letter == 'C') {
        System.out.println(letter);
      } else {
        System.out.print(letter);
      }
      switchSymbol();
      this.notifyAll();
    } catch (InterruptedException e) {
     e.printStackTrace();
   }
  }

  private void switchSymbol() {
    switch (currentLetter) {
      case 'A' -> currentLetter = 'B';
      case 'B' -> currentLetter = 'C';
      case 'C' -> currentLetter = 'A';
    }
  }
}
