package de.telran.filemanager;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PanelController implements Initializable {

  @FXML
  private TextField pathField;
  @FXML
  private ComboBox<String> diskBox;
  @FXML
  private TableView<FileData> table;


  public void selectDisk(ActionEvent actionEvent) {
  }

  public void buttonUp(ActionEvent actionEvent) {
    Path upper = Paths.get(pathField.getText()).getParent();
    if (upper != null) {
      update(upper);
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    TableColumn<FileData, String> fileTypeColumn = new TableColumn<>();
    fileTypeColumn.setCellValueFactory(
        param -> new SimpleStringProperty(param.getValue().getType().getToken()));
    fileTypeColumn.setPrefWidth(30);
    TableColumn<FileData, String> fileNameColumn = new TableColumn<>();
    fileNameColumn.setCellValueFactory(
        param -> new SimpleStringProperty(param.getValue().getFileName()));
    fileNameColumn.setPrefWidth(240);
    TableColumn<FileData, Long> fileSizeColumn = new TableColumn<>();
    fileSizeColumn.setCellValueFactory(
        param -> new SimpleObjectProperty<>(param.getValue().getSize()));
    fileSizeColumn.setPrefWidth(90);

    fileSizeColumn.setCellFactory(column -> {
      return new TableCell<FileData, Long>() {
        @Override
        protected void updateItem(Long item, boolean b) {
          super.updateItem(item, b);
          if (item == null || b) {
            setText("");
            setStyle("");
          } else {
            String text = String.format("%,d bytes", item);
            setText(text);
          }
        }
      };
    });

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
    TableColumn<FileData, String> lastUpdatedColumn = new TableColumn<>();
    lastUpdatedColumn.setCellValueFactory(
        param -> new SimpleStringProperty(param.getValue().getLastModified().format(dtf)));
    lastUpdatedColumn.setPrefWidth(90);

    table.getColumns().addAll(fileTypeColumn, fileNameColumn, fileSizeColumn, lastUpdatedColumn);
    table.getSortOrder().add(fileTypeColumn);

    diskBox.getItems().clear();
    for (Path p : FileSystems.getDefault().getRootDirectories()) {
      diskBox.getItems().add(p.toString());
    }
    if (!diskBox.getItems().isEmpty()) {
      diskBox.getSelectionModel().select(0);
    }

    table.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
          var path = Paths.get(pathField.getText()).resolve(table.getSelectionModel().getSelectedItem()
              .getFileName());
          if (Files.isDirectory(path)) {
            update(path);
          }
        }
      }
    });
update(Paths.get("."));
  }

  private void update(Path path) {
    try {
      pathField.setText(path.normalize().toAbsolutePath().toString());
      table.getItems().clear();
      table.getItems().addAll(Files.list(path).map(FileData::new).toList());
      table.sort();
    } catch (IOException e) {
      Alert alert = new Alert(AlertType.ERROR, "Cannot update list of files");
      alert.showAndWait();
    }
  }
}
