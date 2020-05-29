package controllers;

import fileclient.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import windows.ConnectWindow;

import java.awt.event.ActionEvent;

public class ServerController {
    @FXML private Button browseButton;
    @FXML private Button backButton;
    @FXML private Text successText;
    @FXML private Button startButton;
    private Server server;
    private Thread t1;

    public void handleBackButton(javafx.event.ActionEvent actionEvent) throws Exception{
        server.stop();
        t1.stop();
        ConnectWindow connectWindow = new ConnectWindow();
        Stage stage = (Stage) backButton.getScene().getWindow();
        connectWindow.start(new Stage());
        stage.close();
    }

    public void handleBrowseButton(javafx.event.ActionEvent actionEvent) {
    }

    public void handleStartButton(javafx.event.ActionEvent actionEvent) {
        server = new Server();
        t1 = new Thread(server);
        t1.start();

        startButton.setStyle("visibility:hidden");
    }
}
