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
    private Button butt_cam_1;
    @FXML
    private Button butt_cam_2;
    @FXML
    private Button butt_cam_3;
    @FXML
    private Button butt_cam_4;
    @FXML
    private Button butt_cam_5;
    @FXML
    private Button butt_cam_6;
    @FXML
    private Button butt_cam_7;
    @FXML
    private Button butt_cam_8;
    @FXML
    private Button butt_cam_9;
    @FXML
    private Button butt_cam_10;

    @FXML
    private void on_butt_cam_1() {
        if(sistem.camera[0]==null){
            sistem.camera[0]=getNumesiVolum(sistem.camera[0]);
        }
        else {
            deschide_form_difuzoare();
            butt_cam_2.setDisable(false);
        }
    }
    @FXML
    private void on_butt_cam_2() {
    }
    @FXML
    private void on_butt_cam_3() {
    }
    @FXML
    private void on_butt_cam_4() {
    }
    @FXML
    private void on_butt_cam_5() {
    }
    @FXML
    private void on_butt_cam_6() {
    }
    @FXML
    private void on_butt_cam_7() {
    }
    @FXML
    private void on_butt_cam_8() {
    }
    @FXML
    private void on_butt_cam_9() {
    }
    @FXML
    private void on_butt_cam_10() {
    }

    private Camera getNumesiVolum(Camera camera){
        TextInputDialog dialogNume = new TextInputDialog();
        dialogNume.setTitle("Nume Cameră");
        dialogNume.setHeaderText("Introduceți numele pentru camera " + (sistem.nrcamere + 1));
        dialogNume.setContentText("Nume Cameră:");

        Optional<String> resultNume = dialogNume.showAndWait();
        if (!resultNume.isPresent() || resultNume.get().isEmpty()) {
            // Dacă nu s-a introdus un nume, nu adăugăm camera
            return null;
        }

        String nume=resultNume.toString();

        // Cerem volumul camerei printr-un alt dialog
        TextInputDialog dialogVolum = new TextInputDialog();
        dialogVolum.setTitle("Volum Cameră");
        dialogVolum.setHeaderText("Introduceți volumul pentru camera " + (sistem.nrcamere + 1));
        dialogVolum.setContentText("Volum Cameră (0 - 100):");

        Optional<String> resultVolum = dialogVolum.showAndWait();
        if (!resultVolum.isPresent() || resultVolum.get().isEmpty()) {
            // Dacă nu s-a introdus volumul, nu adăugăm camera
            return null;
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
            return null;
        }
        camera=new Camera(nume,volumCamera);
        return camera;
    }

    private void deschide_form_difuzoare(){
        try {
            FXMLLoader Fdifuzoare = new FXMLLoader(getClass().getResource("Difuzoare.fxml"));
            Scene scene = new Scene(Fdifuzoare.load(),500,600);
            //Creeaza si afiseaza noul stage
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
