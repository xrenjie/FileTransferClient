package fileclient;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application {

    public static String ipAddress;

    public Window(String ipAddress){
        this.ipAddress=ipAddress;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent mainPane = FXMLLoader.load(getClass().getResource("window.fxml"));

        Scene scene = new Scene(mainPane);

        stage.setTitle("Transfer file");
        stage.setScene(scene);
        stage.show();

    }


}
