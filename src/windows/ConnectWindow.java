package windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConnectWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent mainPane = FXMLLoader.load(getClass().getResource("/fxml/connectwindow.fxml"));

        Scene scene = new Scene(mainPane);

        stage.setTitle("Connect to server");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
