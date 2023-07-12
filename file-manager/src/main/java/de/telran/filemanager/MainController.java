package de.telran.filemanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class MainController {

  public VBox leftPanel;
  public VBox rightPanel;

  public void buttonExit(ActionEvent actionEvent) {
    Platform.exit();
  }

  public void buttonCopy(ActionEvent actionEvent) {

  }

  public void buttonMove(ActionEvent actionEvent) {

  }
}
