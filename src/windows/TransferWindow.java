package windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransferWindow extends Application {

    public static String ipAddress;

    public TransferWindow(String ipAddress){
        this.ipAddress=ipAddress;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent mainPane = FXMLLoader.load(getClass().getResource("/fxml/transferwindow.fxml"));

        Scene scene = new Scene(mainPane);

        stage.setTitle("Transfer file");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


}
