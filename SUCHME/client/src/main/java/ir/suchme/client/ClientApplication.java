package ir.suchme.client;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        Scene scene = new Scene(root, 1002, 756);

        primaryStage.setTitle("SUpply CHain Management system (SUCHME)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
