package de.telran.practice.lectures.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
  var executor = Executors.newCachedThreadPool();
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, Thread " + Thread.currentThread().getName(), executor);
    System.out.println(future.get());

    Phaser phaser = new Phaser(1);
    int currentPhase;

    new Thread(() -> {
      try {
        phaser.register();
        System.out.println("Worker First is starting first phase");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep((long) (Math.random() * 2000));
        System.out.println("Worker First is starting second phase");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep((long) (Math.random() * 2000));
        System.out.println("Worker First is starting third phase");
        phaser.arriveAndAwaitAdvance();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    new Thread(() -> {
      try {
        phaser.register();
        System.out.println("Worker Second is starting first phase");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep((long) (Math.random() * 2000));
        System.out.println("Worker Second is starting second phase");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep((long) (Math.random() * 2000));
        System.out.println("Worker Second is starting third phase");
        phaser.arriveAndAwaitAdvance();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    new Thread(() -> {
      try {
        System.out.println("Waiting for the 3rd phase");
        phaser.awaitAdvanceInterruptibly(phaser.getPhase());
        System.out.println("Phase 2 reached");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    currentPhase = phaser.getPhase();
    System.out.println("Current phase " + currentPhase);
    System.out.println("Waiting other thread from main ");
    phaser.arriveAndAwaitAdvance();

    System.out.println("Starting the next phase");
    currentPhase = phaser.getPhase();
    System.out.println("Current phase " + currentPhase);
    phaser.arriveAndAwaitAdvance();

    System.out.println("Starting the next phase");
    currentPhase = phaser.getPhase();
    System.out.println("Current phase " + currentPhase);
    phaser.arriveAndAwaitAdvance();

    System.out.println("Finish");
  }

}
