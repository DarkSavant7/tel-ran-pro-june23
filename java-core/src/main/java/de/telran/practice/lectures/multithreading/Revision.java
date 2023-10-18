package de.telran.practice.lectures.multithreading;

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Revision {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Hashtable<String, String> hashtable = new Hashtable<>();
    Vector<String> vector = new Vector<>();
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

//    futureExample();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 1 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 1 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 2 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 2 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 3 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 3 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 4 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 4 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.writeLock().lock();
        System.out.println("Write 1 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Write 1 finish");
        lock.writeLock().unlock();
      }
    }).start();
    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 5 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 5 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.writeLock().lock();
        System.out.println("Write 2 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Write 2 finish");
        lock.writeLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 6 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 6 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 7 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 7 finish");
        lock.readLock().unlock();
      }
    }).start();

    new Thread(() -> {
      try {
        lock.readLock().lock();
        System.out.println("Read 8 start");
        Thread.sleep((long) (Math.random() * 3000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Read 8 finish");
        lock.readLock().unlock();
      }
    }).start();
  }

  private static void futureExample() throws InterruptedException, ExecutionException {
    Callable<String> callable = () -> "hello";
//    new Callable<String>() {
//
//      @Override
//      public String call() throws Exception {
//        return "hello";
//      }
//    };

    FutureTask<String> ft = new FutureTask<>(callable);
    new Thread(ft).start();

    System.out.println(ft.get());

    ExecutorService service = Executors.newFixedThreadPool(2);
    Future<String> future = service.submit(callable);

    System.out.println(future.get());
    service.shutdown();
  }
}
