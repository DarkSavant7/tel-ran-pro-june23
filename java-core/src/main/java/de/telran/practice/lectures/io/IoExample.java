package de.telran.practice.lectures.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IoExample {

  public static void main(String[] args) throws IOException {
//    simpleBasicChecks();
//    filesCreateDeleteMove();
//    fileMove();
//    gettingListOfAllFiles();
//    simpleRead();
//    readExamples();
  }

  private static void readExamples() throws IOException {
    System.out.println("=================================");
    System.out.println("SIMPLE READ");
    System.out.println("=================================");
    try (FileInputStream fis = new FileInputStream("files/big-file.txt")) {
      int b;
      int fake;
      long start = System.currentTimeMillis();
      while ((b = fis.read()) > -1) {
        fake = b;
//        System.out.print((char) b);
      }
      long end = System.currentTimeMillis();
      System.out.println("Time: " + (end - start));
    }

    System.out.println("=================================");
    System.out.println("HANDMADE BUFFER READ");
    System.out.println("=================================");
    try (FileInputStream fis = new FileInputStream("files/big-file.txt")) {
      byte[] buf = new byte[8192];
      int b;
      int fake;
      long start = System.currentTimeMillis();
      while ((b = fis.read(buf)) > -1) {
        fake = b;
//        System.out.print((char) b);
      }
      long end = System.currentTimeMillis();
      System.out.println("Time handmade buffer: " + (end - start));
    }

    System.out.println("=================================");
    System.out.println("BUFFERED READ");
    System.out.println("=================================");
    try (BufferedInputStream bis = new BufferedInputStream(
        new FileInputStream("files/big-file.txt"))) {
      int b;
      int fake;
      long start = System.currentTimeMillis();
      while ((b = bis.read()) > -1) {
        fake = b;
//        System.out.print((char) b);
      }
      long end = System.currentTimeMillis();
      System.out.println("Time buffered stream: " + (end - start));
    }
  }

  private static void simpleRead() throws IOException {
    //    FileInputStream fis = new FileInputStream("files/test1.txt");
//    //.........
//    fis.close();
//    FileInputStream fis = null;
//    try {
//      fis = new FileInputStream("files/test1.txt");
//    } catch (IOException e) {
////      System.exit(1);
//      //.......
//    } catch (RuntimeException e) {
//      //.....
//    } finally {
//      if (fis != null) {
//        fis.close();
//      }
//    }
    try (FileInputStream fis = new FileInputStream("files/big-file.txt")) {
      int b;
      int fake;
      long start = System.currentTimeMillis();
      while ((b = fis.read()) > -1) {
        fake = b;
//        System.out.print((char) b);
      }
      long end = System.currentTimeMillis();
      System.out.println("Time: " + (end - start));
    }
  }

  private static void gettingListOfAllFiles() {
    File root = new File("/home/persi/Documents/tel-ran-pro-june23");
    printAllFiles(root, "");
  }

  private static void printAllFiles(File root, String step) {
    if (root.isFile()) {
      System.out.println(step + "F: " + root.getName());
      return;
    } else {
      System.out.println(step + "D: " + root.getName());
    }
//    root.listFiles((dir, name) -> name.endsWith(".txt"));
//    root.listFiles(file -> file.getName().endsWith("txt"));
    File[] files = root.listFiles(file -> !file.getName().startsWith("."));

    for (File file : files) {
      printAllFiles(file, step + ". ");
    }
  }

  private static void fileMove() {
    File file = new File("files/test1.txt");
    file.renameTo(new File("files/1/2/3/4/5/6/newFile.txt"));
  }

  private static void filesCreateDeleteMove() throws IOException {
    File file = new File("files/test2.txt");

    if (!file.exists()) {
      file.createNewFile();
    }
    File parent = file.getParentFile();
    System.out.println(parent.getAbsolutePath());
    file.delete();
    file.createNewFile();
    File dir = new File("files/1/2/3/4/5/6");
    dir.mkdirs();
    file.renameTo(new File("files/1/2/3/4/5/6/newFile.txt"));
  }

  private static void simpleBasicChecks() {
    File file = new File("files/test1.txt");
    System.out.println(file.exists());
    System.out.println(file.isFile());
    System.out.println(file.canExecute());
    System.out.println(file.isHidden());
    System.out.println(file.canRead());
    System.out.println(file.canWrite());
  }
}
