package controllers;

import fileclient.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import windows.ConnectWindow;

import java.io.File;

public class ServerController {
    @FXML private Button browseButton;
    @FXML private Button backButton;
    @FXML private Text directoryName;
    @FXML private Button startButton;
    @FXML private Text statusText;
    private Server server = new Server();
    private Thread t1;

    public void handleBackButton(javafx.event.ActionEvent actionEvent) throws Exception{
        try {
            server.stop();
            t1.stop();
        }catch(Exception e){e.printStackTrace();}
        ConnectWindow connectWindow = new ConnectWindow();
        Stage stage = (Stage) backButton.getScene().getWindow();
        connectWindow.start(new Stage());
        stage.close();
    }

    public void handleBrowseButton(javafx.event.ActionEvent actionEvent) {
        try {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Select a folder");
            File folder = directoryChooser.showDialog((Stage) backButton.getScene().getWindow());
            if (folder != null) {
                server.changeDirectory(folder.getAbsolutePath());
                directoryName.setText(folder.getAbsolutePath());
                System.out.println(folder.getAbsolutePath());
                System.out.println(server.directory);
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void handleStartButton(javafx.event.ActionEvent actionEvent) {
        t1 = new Thread(server);
        t1.start();
        statusText.setText("Server started");
        startButton.setStyle("visibility:hidden");
    }
}
