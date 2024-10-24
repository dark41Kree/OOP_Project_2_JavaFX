package View;

import Controller.Audio_System_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AudioSystem_View extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader Fcasa = new FXMLLoader(Audio_System_Controller.class.getResource("Audio_System.fxml"));
        Scene scene = new Scene(Fcasa.load(), 420, 440);
        stage.setTitle("Fereastra pentru initializarea sistemului audio!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}