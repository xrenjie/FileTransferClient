package controllers;

import fileclient.Client;
import windows.ConnectWindow;
import windows.TransferWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TransferController {
    @FXML private Button browseButton;
    @FXML private Button transferButton;
    @FXML private Button backButton;
    @FXML private Text filenameText;
    @FXML private Text successText;
    private Client client;
    private File file;




    @FXML protected void handleBrowseButton(ActionEvent event) throws Exception{
        file = getFile();
        if(file!=null)
            filenameText.setText(file.getName());

    }

    @FXML protected void handleTransferButton(ActionEvent event) throws Exception{
        try {
            successText.setText("Transferring");
            client = new Client(TransferWindow.ipAddress);
            int success = 0;
            if (file != null) {
                success = client.sendFilename(file);
                client.sendFile(file);
            }
            if (success == 1) {
                successText.setText("Success!");
            } else {
                successText.setText("Unsuccessful, check connection IP");
            }
        }catch(Exception e){e.printStackTrace();}
    }

    @FXML protected void handleBackButton(ActionEvent event) throws Exception{
        ConnectWindow connectWindow = new ConnectWindow();
        Stage stage = (Stage) backButton.getScene().getWindow();
        connectWindow.start(new Stage());
        stage.close();
    }

    private File getFile (){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        File file = fileChooser.showOpenDialog((Stage)backButton.getScene().getWindow());
        if (file == null) {
            return null;
        }
        return file;
    }



}