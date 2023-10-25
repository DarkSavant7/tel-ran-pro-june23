package de.telran.practice.lectures.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {

  private static final int PORT = 8189;

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Server started");
      while (true) {
        //waiting for connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // open input output streams
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
          //wait for input
          while (!reader.ready());

          //read and write to console
          System.out.println();
          StringBuilder sb = new StringBuilder();
          while (reader.ready()) {
            var line = reader.readLine();
            sb.append(line);
            System.out.println(line);
//            System.out.println(reader.readLine());
          }
          System.out.println(sb);
//          int numIndex = sb.indexOf("\"number\": ") + 10;
//          int spaceIndex = sb.indexOf(" ", numIndex);
//          int bracketIndex = sb.indexOf("}", numIndex);
//          int signIndex = sb.indexOf(",", numIndex);
//          var index = Math.min(signIndex, Math.min(spaceIndex, bracketIndex));
          int start = sb.indexOf("number=") + 7;
//          String number = sb.substring(numIndex, index);
          String number = sb.substring(start);
          System.out.println(number);
          var num = Integer.parseInt(number);
          var result = num * 2;
//{"number": 123}
          //send answer
          writer.println("HTTP/1.1 200 OK");
          writer.println("Content-Type: text/html; charset=utf-8");
          writer.println("Answer: " + result);
          writer.println();
          writer.println("{\"answer\": " + result + "}");
//          writer.println("<p>HELLO WORLD!!!</p>");
//          writer.println("<p>HELLO WORLD!!!</p>");
//          writer.println("<p>HELLO WORLD!!!</p>");
//          writer.println("<p>HELLO WORLD!!!</p>");
          writer.println();
          writer.flush();

          System.out.println("Client disconnected");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
