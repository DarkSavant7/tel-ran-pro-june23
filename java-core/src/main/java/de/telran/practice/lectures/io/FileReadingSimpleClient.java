package de.telran.practice.lectures.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileReadingSimpleClient {

  private static final int PORT = 8189;
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    try (Socket socket = new Socket(HOST, PORT)) {
      System.out.println("Connected");
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      byte[] data = readFile();
      System.out.println("Data received");
      System.out.println(new String(data));
      out.write(data);
      while (true){
        Thread.sleep(1000);
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  static byte[] readFile() throws IOException {
    try (FileInputStream fis = new FileInputStream("files/test1.txt")) {
      return fis.readAllBytes();
    }
  }
}
