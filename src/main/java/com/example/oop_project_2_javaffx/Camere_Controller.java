package com.example.oop_project_2_javaffx;


import AudioSystem.Camera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static AudioSystem.AudioSystem.sistem;

public class Camere_Controller {

    @FXML
    private Label label_nu_aveti_camere;
    @FXML
    private Button add_camera_buton;

    @FXML
    private VBox camereContainer; // Referință la VBox din FXML

    @FXML
    private Button[] camere_butoane = new Button[10]; // Declarăm un array de butoane

    @FXML
    private Scene[] scene_d = new Scene[10];


    public void on_add_camera() {

        TextInputDialog dialogNume = new TextInputDialog();
        dialogNume.setTitle("Nume Cameră");
        dialogNume.setHeaderText("Introduceți numele pentru camera " + (sistem.nrcamere + 2));
        dialogNume.setContentText("Nume Cameră:");

        Optional<String> resultNume = dialogNume.showAndWait();
        if (!resultNume.isPresent() || resultNume.get().isEmpty()) {
            // Dacă nu s-a introdus un nume, nu adăugăm camera
            return;
        }

        // Cerem volumul camerei printr-un alt dialog
        TextInputDialog dialogVolum = new TextInputDialog();
        dialogVolum.setTitle("Volum Cameră");
        dialogVolum.setHeaderText("Introduceți volumul pentru camera " + (sistem.nrcamere + 2));
        dialogVolum.setContentText("Volum Cameră (0 - 100):");

        Optional<String> resultVolum = dialogVolum.showAndWait();
        if (!resultVolum.isPresent() || resultVolum.get().isEmpty()) {
            // Dacă nu s-a introdus volumul, nu adăugăm camera
            return;
        }

        int volumCamera;
        try {
            volumCamera = Integer.parseInt(resultVolum.get());
            if (volumCamera < 0 || volumCamera > 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            // Dacă volumul introdus nu este valid, afișăm o eroare și oprim procesul
            new Alert(Alert.AlertType.ERROR, "Volum invalid! Introduceți un număr între 0 și 100.", ButtonType.OK).showAndWait();
            return;
        }

        // Creștem numărul de camere
        if(sistem.nrcamere<9) {
            sistem.nrcamere++;
        }

        // Inițializăm și adăugăm butonul în VBox
        camere_butoane[sistem.nrcamere] = new Button("Camera " + (sistem.nrcamere + 1) + ": " + resultNume.get());
        camereContainer.getChildren().add(camere_butoane[sistem.nrcamere]);

        // Inițializăm camera cu numele și volumul introdus
        sistem.camera[sistem.nrcamere] = new Camera(resultNume.get(), volumCamera);
        int index = sistem.nrcamere; // Stocăm indexul pentru utilizarea în lambda

        // Atribuim un handler pentru fiecare buton, afișând informațiile despre camera respectivă
        camere_butoane[sistem.nrcamere].setOnAction(event -> {
            //new Alert(Alert.AlertType.INFORMATION, "Camera: " + sistem.camera[index].getNume() + "\nVolum: " + sistem.camera[index].getVolume(), ButtonType.OK).showAndWait();
            try {
                FXMLLoader Fdifuzoare = new FXMLLoader(getClass().getResource("Difuzoare.fxml"));
                scene_d[sistem.nrcamere] = new Scene(Fdifuzoare.load(),500,600);
                //Creeaza si afiseaza noul stage
                Stage newStage = new Stage();
                newStage.setScene(scene_d[sistem.nrcamere]);
                newStage.setTitle("Camera: "+ sistem.camera[sistem.nrcamere].getNume()+" , Volum: "+sistem.camera[sistem.nrcamere].getVolume());
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        if(sistem.nrcamere>(-1)) {label_nu_aveti_camere.setText("Numele Audio Sistemului: "+sistem.getNumeSistem());
            label_nu_aveti_camere.setStyle("-fx-text-fill: #12a0ff;");}


        // Dacă avem mai mult de 10 camere, ascundem butonul de adăugare
        if (sistem.nrcamere >= 9) {
            add_camera_buton.setVisible(false);
            add_camera_buton.setText("A-ti atins numarul maxim de camere.");
        }
    }


    public void on_click_camera() {

    }
}
