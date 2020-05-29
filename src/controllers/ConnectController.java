package controllers;

import fileclient.Server;
import windows.ServerWindow;
import windows.TransferWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectController {
    @FXML private TextField addressField;
    @FXML private Button connectButton;
    @FXML private Button startServerButton;

    @FXML protected void handleConnectButton(ActionEvent event) throws Exception{
        String ipAddress = addressField.getText();
        System.out.println(ipAddress);
        if(!ipAddress.equals("")){
            Stage stage = (Stage) connectButton.getScene().getWindow();
            TransferWindow transferWindow = new TransferWindow(ipAddress);
            transferWindow.start(new Stage());
            stage.close();
        }
    }

    @FXML protected void handleStartServerButton(ActionEvent event) throws Exception{
        Stage stage = (Stage) connectButton.getScene().getWindow();
        ServerWindow serverWindow = new ServerWindow();
        serverWindow.start(new Stage());
        stage.close();
    }


}