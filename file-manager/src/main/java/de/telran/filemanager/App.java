package de.telran.filemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  public static void run(String[] args) {
    launch(args);
  }


  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(this.getClass().getResource("/fxml/manager.fxml"));
    Parent parent = loader.load();
    Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.show();
  }
}
