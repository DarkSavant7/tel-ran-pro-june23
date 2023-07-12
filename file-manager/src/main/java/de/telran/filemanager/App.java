package de.telran.filemanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
 private static Scene scene;


  @Override
  public void start(Stage stage) throws Exception {
     scene = new Scene(load("fxml/manager.fxml"), 1600, 900);
     stage.setTitle("File Manager");
     stage.setScene(scene);
     stage.show();
  }

  private static Parent load(String path) throws IOException {
    var loader = new FXMLLoader(App.class.getResource(path));
    return loader.load();
  }

  public static void main(String[] args) {
    launch();
  }
}
