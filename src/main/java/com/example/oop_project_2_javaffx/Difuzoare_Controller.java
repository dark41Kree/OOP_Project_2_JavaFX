package com.example.oop_project_2_javaffx;

import AudioSystem.Camera;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import static AudioSystem.AudioSystem.sistem;


public class Difuzoare_Controller {

    @FXML
    private Label label_cam_info;
    @FXML
    private Label difuzoare_label;
    @FXML
    private Button buton_add_difuzor;
    @FXML
    private Button buton_sterge_difuzor;

    private Camera camera;


    public void setCamera(Camera camera){
        this.camera=camera;
        label_cam_info.setText("Camera: "+camera.getNume()+"   Volum: "+ camera.getVolume());
    }


    @FXML
    protected void on_add_difuzor(){

        new Alert(Alert.AlertType.INFORMATION, "Camera: "+ camera.getNume(), ButtonType.OK).showAndWait();




    }

    @FXML
    protected void on_sterge_difuzor() {
    }







}
