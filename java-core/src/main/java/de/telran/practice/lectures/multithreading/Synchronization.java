package de.telran.practice.lectures.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Synchronization {

  public static void main(String[] args) throws InterruptedException {
//    executorsExample();
//    schedulers();

  }

  private static void schedulers() {
    var scheduler = Executors.newSingleThreadScheduledExecutor();

//    scheduler.schedule(() -> System.out.println("Schedule!"), 2, TimeUnit.SECONDS);
//    scheduler.scheduleAtFixedRate(() -> System.out.println("Schedule!"), 3, 1, TimeUnit.SECONDS);
    scheduler.scheduleWithFixedDelay(() -> System.out.println("Schedule!"), 3, 1, TimeUnit.SECONDS);
  }

  private static void executorsExample() {
    //    var thread = new Thread(() -> System.out.println("Hello world!"));
//    thread.start();
//    thread.join();
//    thread.start();
//    var executor = new ThreadPoolExecutor(1, 10, 2, TimeUnit.MINUTES,
//        new ArrayBlockingQueue<>(100, true));
//    var executorService = Executors.newSingleThreadExecutor();
//    var executorService = Executors.newFixedThreadPool(4);
//    var executorService = Executors.newCachedThreadPool();
//    var executorService = Executors.newScheduledThreadPool(4);
//    var executorService = Executors.newSingleThreadScheduledExecutor();
    var executorService = new ThreadPoolExecutor(0, 2, 60, TimeUnit.SECONDS,
        new SynchronousQueue<>(true));

    for (int i = 0; i < 10; i++) {
      int j = i;
      executorService.execute(() -> {
        System.out.printf("Task #%d started. Thread name: %s%n", j,
            Thread.currentThread().getName());
        try {
          Thread.sleep((long) (1000 + 2000 * Math.random()));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.printf("Task #%d ended. Thread name: %s%n", j, Thread.currentThread().getName());
      });
    }

//    var future = executorService.submit(() -> "Hello world!");
    System.out.println("All tasks given");

    executorService.shutdown();
//   var unfinishedTasks = executorService.shutdownNow();

//    System.out.println("Unfinished tasks: " + unfinishedTasks);

    System.out.println();

//    var newExecutor = Executors.newCachedThreadPool();
//    newExecutor.invokeAll(unfinishedTasks);
//    unfinishedTasks.stream()
//            .forEach(newExecutor::execute);
//    newExecutor.shutdown();
    System.out.println("MAIN thread finishes");
//    try {
//      System.out.println(future.get());
//    } catch (ExecutionException e) {
//      e.printStackTrace();
//    }
  }
}
