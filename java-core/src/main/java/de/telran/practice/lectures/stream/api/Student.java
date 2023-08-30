package de.telran.practice.lectures.stream.api;

import java.util.HashSet;
import java.util.Set;

public class Student {

  private int id;
  private String name;
  private Set<String> books;

  public void addBook(String book) {
    if (this.books == null) {
      this.books = new HashSet<>();
    }

    this.books.add(book);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getBooks() {
    return books;
  }

  public void setBooks(Set<String> books) {
    this.books = books;
  }
}
