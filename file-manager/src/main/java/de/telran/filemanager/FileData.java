package de.telran.filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class FileData {

  private String fileName;
  private FileType type;
  private long size;
  private LocalDateTime lastModified;

  public FileData(Path path) {
    try {
      this.fileName = path.getFileName().toString();
      this.type = Files.isDirectory(path) ? FileType.DIRECTORY : FileType.FILE;
      this.size = Files.size(path);
      this.lastModified = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(),
          ZoneOffset.UTC);
    } catch (IOException e) {
      throw new RuntimeException("Unable to read file data", e);
    }
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public FileType getType() {
    return type;
  }

  public void setType(FileType type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public LocalDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }
}
