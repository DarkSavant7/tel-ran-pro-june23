package de.telran.filemanager;

public enum FileType {
  FILE("F"),
  DIRECTORY("D");

  private String token;

  FileType(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
