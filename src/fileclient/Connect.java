package fileclient;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Connect extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent mainPane = FXMLLoader.load(getClass().getResource("connect.fxml"));

        Scene scene = new Scene(mainPane);

        stage.setTitle("Connect to server");
        stage.setScene(scene);
        stage.show();
    }

    public void end(Stage stage){
        stage.close();
    }
}
