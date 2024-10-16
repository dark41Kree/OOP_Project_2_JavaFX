package com.example.oop_project_2_javaffx;

import AudioSystem.AudioSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static AudioSystem.AudioSystem.get_System;
import static AudioSystem.AudioSystem.sistem;

public class Audio_System_Controller {

    @FXML
    private Button Sistem_next_camere;
    @FXML
    private Button button_sistem_form;
    @FXML
    private TextField field_nume_sistem;
    @FXML
    private Label label_nume_sistem;


    @FXML
    protected void onHelloButtonClick() {

        if(field_nume_sistem.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Introdu numele pentru Sistemul Audio si apasa Next" , ButtonType.OK).showAndWait();
        } else {
            get_System(field_nume_sistem.getText());
            new Alert(Alert.AlertType.INFORMATION,"Sistemul Audio a fost creat cu succes!" , ButtonType.OK).showAndWait();
            button_sistem_form.setVisible(false);
            field_nume_sistem.setVisible(false);
            label_nume_sistem.setText("Numele Sistemului: "+sistem.getNumeSistem());
            Sistem_next_camere.setVisible(true);
        }

    }

    @FXML
    protected void onSistem_next_camere() {
        //Inchide fereastra sistem
        Stage stage = (Stage) Sistem_next_camere.getScene().getWindow();
        stage.close();

        //Incarca noua fereastra pentru camere
        try {
            FXMLLoader Fcamere = new FXMLLoader(getClass().getResource("Camere.fxml"));
            Scene scene = new Scene(Fcamere.load(),500,600);
            //Creeaza si afiseaza noul stage
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}