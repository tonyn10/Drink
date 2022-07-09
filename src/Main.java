import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Intro.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Drink, Stay Hydrated");

        Image icon = new Image("WaterDrop.png");
        stage.getIcons().add(icon);

        stage.show();
    }
}