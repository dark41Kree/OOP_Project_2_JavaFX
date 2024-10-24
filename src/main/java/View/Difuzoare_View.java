package View;

import AudioSystem.Camera;
import Controller.Difuzoare_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Difuzoare_View {

    @FXML
    public static void open_Difuzoare_View(Camera[] arrayCamere, int index) {
        try {
            FXMLLoader Fdifuzoare = new FXMLLoader(Difuzoare_Controller.class.getResource("Difuzoare.fxml"));

            Parent root = Fdifuzoare.load();
            Difuzoare_Controller controller = Fdifuzoare.getController();

            controller.setCamera(arrayCamere[index]);


            Scene scene = new Scene(root, 500, 600);
            Stage newStage = new Stage();
            newStage.setTitle("Manager de difuzoare");
            newStage.setScene(scene);

            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
