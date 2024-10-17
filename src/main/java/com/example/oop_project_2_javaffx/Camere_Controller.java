package com.example.oop_project_2_javaffx;


import AudioSystem.Camera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

import static AudioSystem.AudioSystem.sistem;

public class Camere_Controller {

    @FXML
    private Label label_nume_sistem;
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
    public void setLabel_nume_sistem() {
        label_nume_sistem.setText(sistem.getNumeSistem());
    }


    @FXML
    private void on_butt_cam_1() {
        if(sistem.camera[0]==null){
            sistem.camera[0]=getNumesiVolum(sistem.camera[0],0);
            if(sistem.camera[0]!=null){butt_cam_2.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,0);
        }
    }
    @FXML
    private void on_butt_cam_2() {
        if(sistem.camera[1]==null){
            sistem.camera[1]=getNumesiVolum(sistem.camera[1],1);
            if(sistem.camera[1]!=null){butt_cam_3.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,1);
        }
    }
    @FXML
    private void on_butt_cam_3() {
        if(sistem.camera[2]==null){
            sistem.camera[2]=getNumesiVolum(sistem.camera[2],2);
            if(sistem.camera[2]!=null){butt_cam_4.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,2);
        }
    }
    @FXML
    private void on_butt_cam_4() {
        if(sistem.camera[3]==null){
            sistem.camera[3]=getNumesiVolum(sistem.camera[3],3);
            if(sistem.camera[3]!=null){butt_cam_5.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,3);
        }
    }
    @FXML
    private void on_butt_cam_5() {
        if(sistem.camera[4]==null){
            sistem.camera[4]=getNumesiVolum(sistem.camera[4],4);
            if(sistem.camera[4]!=null){butt_cam_6.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,4);
        }
    }
    @FXML
    private void on_butt_cam_6() {
        if(sistem.camera[5]==null){
            sistem.camera[5]=getNumesiVolum(sistem.camera[5],5);
            if(sistem.camera[5]!=null){butt_cam_7.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,5);
        }
    }
    @FXML
    private void on_butt_cam_7() {
        if(sistem.camera[6]==null){
            sistem.camera[6]=getNumesiVolum(sistem.camera[6],6);
            if(sistem.camera[6]!=null){butt_cam_8.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,6);
        }
    }
    @FXML
    private void on_butt_cam_8() {
        if(sistem.camera[7]==null){
            sistem.camera[7]=getNumesiVolum(sistem.camera[7],7);
            if(sistem.camera[7]!=null){butt_cam_9.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,7);
        }
    }
    @FXML
    private void on_butt_cam_9() {
        if(sistem.camera[8]==null){
            sistem.camera[8]=getNumesiVolum(sistem.camera[8],8);
            if(sistem.camera[8]!=null){butt_cam_10.setDisable(false);}
        }
        else {
            deschide_form_difuzoare(sistem.camera,8);
        }
    }
    @FXML
    private void on_butt_cam_10() {
        if(sistem.camera[9]==null){
            sistem.camera[9]=getNumesiVolum(sistem.camera[9],9);
        }
        else {
            deschide_form_difuzoare(sistem.camera,9);
        }
    }

    private Camera getNumesiVolum(Camera camera,int index){
        TextInputDialog dialogNume = new TextInputDialog();
        dialogNume.setTitle("Nume Cameră");
        dialogNume.setHeaderText("Introduceți numele pentru camera " + (index + 1));
        dialogNume.setContentText("Nume Cameră:");

        Optional<String> resultNume = dialogNume.showAndWait();
        if (resultNume.get().equals("") || resultNume.get().isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Nume cameră invalid!", ButtonType.OK).showAndWait();
            return null;
        }
        String nume=resultNume.get();

        TextInputDialog dialogVolum = new TextInputDialog();
        dialogVolum.setTitle("Volum Cameră");
        dialogVolum.setHeaderText("Introduceți volumul pentru camera " + (sistem.nrcamere + 2));
        dialogVolum.setContentText("Volum Cameră (0 - 100):");

        Optional<String> resultVolum = dialogVolum.showAndWait();
        if (!resultVolum.isPresent() || resultVolum.get().isEmpty()) {
            return null;
        }

        int volumCamera;
        try {
            volumCamera = Integer.parseInt(resultVolum.get());
            if (volumCamera < 0 || volumCamera > 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Volum invalid! Introduceți un număr întreg între 0 și 100.", ButtonType.OK).showAndWait();
            return null;
        }
        camera=new Camera(nume,volumCamera);
        sistem.nrcamere++;
        return camera;
    }

    private void deschide_form_difuzoare(Camera[] arrayCamere,int index){
        try {
            FXMLLoader Fdifuzoare = new FXMLLoader(getClass().getResource("Difuzoare.fxml"));

            Parent root= Fdifuzoare.load();
            Difuzoare_Controller controller=Fdifuzoare.getController();

            controller.setCamera(arrayCamere[index]);
            controller.afiseazaDifuzoare();

            Scene scene = new Scene(root,500,600);
            Stage newStage = new Stage();
            newStage.setScene(scene);

            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
