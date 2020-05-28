package fileclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class WindowController {
    @FXML private Button browse;
    @FXML private Button transfer;
    @FXML private Text textbox;
    @FXML private Text connectionIP;
    private Client client;
    private File file;




    @FXML protected void handleBrowseButton(ActionEvent event) throws Exception{
        file = getFile();
        textbox.setText(file.getName());

    }

    @FXML protected void handleTransferButton(ActionEvent event) throws Exception{
        client = new Client(Window.ipAddress);
        int success = 0;
        if(file!=null) {
            success = client.sendFilename(file);
            client.sendFile(file);
        }
        if(success==1){
            connectionIP.setText("Success!");
        }else{
            connectionIP.setText("Unsuccessful, check connection IP");
        }
    }

    private File getFile (){
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file == null) {
                return null;
            }

            //String fileName = chooser.getSelectedFile().getAbsolutePath();
            return file;
        }
        return null;

    }

}