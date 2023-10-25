package de.telran.practice.lectures.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpSimpleClient {

  private static final int PORT = 8189;
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    try (Socket socket = new Socket(HOST, PORT)) {
      System.out.println("Connected");
      Scanner scanner = new Scanner(System.in);
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      while (true) {
        String message = scanner.nextLine();
        out.writeUTF(message);
        Thread.sleep(200);
        message = in.readUTF();
        System.out.println("Received: " + message);
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
