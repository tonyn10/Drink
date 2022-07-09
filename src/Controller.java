import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    private Rectangle myRectangle;
    private double height = 50;
    private static final double MAX_HEIGHT = 290;

    String musicFile = "WaterSound.m4a";    // note: could accept m4a or mp3
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void start(ActionEvent event) throws IOException {
        // switch to other scene
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void dispense(ActionEvent e) {
        // doesn't exceed height of cup
        if(height < MAX_HEIGHT) {
            myRectangle.setHeight(height += 10);
            mediaPlayer.play();
            mediaPlayer.seek(Duration.seconds(0.0));    // reset
        }
    }
}
