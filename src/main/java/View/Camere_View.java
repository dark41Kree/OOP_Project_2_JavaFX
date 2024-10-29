package View;

import Controller.Camere_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Camere_View {

    @FXML
    public static void open_Camere_View() {
        try {
            FXMLLoader Fcamere = new FXMLLoader(Camere_Controller.class.getResource("Camere.fxml"));
            Scene scene = new Scene(Fcamere.load(), 500, 600);

            Camere_Controller camere_controller = Fcamere.getController();
            camere_controller.setLabel_nume_sistem();


            Stage newStage = new Stage();

            newStage.setTitle("Manager de camere");
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
