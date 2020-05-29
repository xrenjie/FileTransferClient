package windows;


import fileclient.Server;
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



public class ServerWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent p = FXMLLoader.load(getClass().getResource("/fxml/serverwindow.fxml"));

        Scene scene = new Scene(p);

        stage.setTitle("Server running");
        stage.setScene(scene);
        stage.show();
    }
}
