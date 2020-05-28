package fileclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class ConnectController {
    @FXML private TextField addressfield;
    @FXML private Button connectbutton;
    @FXML private Pane connectpane;

    @FXML protected void handleConnectButton(ActionEvent event) throws Exception{
        String ipAddress = addressfield.getText();
        Stage stage = (Stage) connectbutton.getScene().getWindow();
        if(ipAddress!=""){
            Window window = new Window(ipAddress);
            window.start(new Stage());
            stage.close();
        }


    }


}