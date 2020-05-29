package windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ServerWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent p = FXMLLoader.load(getClass().getResource("/fxml/serverwindow.fxml"));

        Scene scene = new Scene(p);

        stage.setTitle("Server running");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
