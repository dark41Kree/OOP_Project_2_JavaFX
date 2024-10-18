package com.example.oop_project_2_javaffx;

import AudioSystem.Camera;
import AudioSystem.Difuzor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;


public class Difuzoare_Controller {



    @FXML
    private Label label_cam_info;
    @FXML
    private Button butt_dif_1;
    @FXML
    private Button butt_dif_2;
    @FXML
    private Button butt_dif_3;
    @FXML
    private Button butt_dif_4;
    @FXML
    private Button butt_dif_5;
    @FXML
    private Button butt_back_dif;
    @FXML
    private Button buton_add_difuzor;


    private Camera camera;


    public void setCamera(Camera camera){
        this.camera=camera;
        label_cam_info.setText("Camera: "+camera.getNume()+"   Volum: "+ camera.getVolume());
        if(camera.difuzor[0]!=null){butt_dif_2.setDisable(false);}
        if(camera.difuzor[1]!=null){butt_dif_3.setDisable(false);}
        if(camera.difuzor[2]!=null){butt_dif_4.setDisable(false);}
        if(camera.difuzor[3]!=null){butt_dif_5.setDisable(false);}
    }

    @FXML
    private void on_dif_cam_1() {
        if(camera.difuzor[0]==null){
            getPozitiesiFrecventa();
            if(camera.difuzor[0]!=null){butt_dif_2.setDisable(false);}
        }
        else {
            deschide_info_difuzor(camera.difuzor,0);
        }
    }
    @FXML
    private void on_dif_cam_2() {
        if(camera.difuzor[1]==null){
            getPozitiesiFrecventa();
            if(camera.difuzor[1]!=null){butt_dif_3.setDisable(false);}
        }
        else {
            deschide_info_difuzor(camera.difuzor,1);        }
    }
    @FXML
    private void on_dif_cam_3() {
        if(camera.difuzor[2]==null){
            getPozitiesiFrecventa();
            if(camera.difuzor[2]!=null){butt_dif_4.setDisable(false);}
        }
        else {
            deschide_info_difuzor(camera.difuzor,2);        }
    }
    @FXML
    private void on_dif_cam_4() {
        if(camera.difuzor[3]==null){
            getPozitiesiFrecventa();
            if(camera.difuzor[3]!=null){butt_dif_5.setDisable(false);}
        }
        else {
            deschide_info_difuzor(camera.difuzor,3);        }
    }
    @FXML
    private void on_dif_cam_5() {
        if(camera.difuzor[4]==null){
            getPozitiesiFrecventa();
        }
        else {
            deschide_info_difuzor(camera.difuzor,4);        }
    }



    private void getPozitiesiFrecventa(){
        TextInputDialog dialogPozitie = new TextInputDialog();
        dialogPozitie.setTitle("Pozitie difuzor");
        dialogPozitie.setHeaderText("Introduceți pozitia pentru difuzorul "+(camera.nrdifuzoare+1)+" (FR,FL,Center,RR,RB)");
        dialogPozitie.setContentText("Pozitie difuzor:");

        Optional<String> resultPozitie = dialogPozitie.showAndWait();
        if (resultPozitie.get().isBlank()){
            new Alert(Alert.AlertType.ERROR, "Pozitie difuzor invalida!", ButtonType.OK).showAndWait();
            return;
        }
        String pozitie= resultPozitie.get();

        TextInputDialog dialogFrecventa = new TextInputDialog();
        dialogFrecventa.setTitle("Frecventa difuzor");
        dialogFrecventa.setHeaderText("Introduceți frecventa pentru difuzorul "+(camera.nrdifuzoare+1)+" (Low,Mid,High)");
        dialogFrecventa.setContentText("Frecventa difuzor:");

        Optional<String> resultFrecventa = dialogFrecventa.showAndWait();
        if (resultFrecventa.get().isBlank()){
        new Alert(Alert.AlertType.ERROR, "Frecventa difuzor invalida!", ButtonType.OK).showAndWait();
            return;
        }
        String frecventa= resultFrecventa.get();
        camera.addDifuzor(pozitie,frecventa);

    }

    public void deschide_info_difuzor(Difuzor[] arraydifuzoare, int index){

            new Alert(Alert.AlertType.INFORMATION,"Camera: "+camera.getNume()+"\n"+"Difuzorul "+(index+1)+"\n"+"Pozitia: "+arraydifuzoare[index].getPozitie()+"\n"+"Frecventa: "+arraydifuzoare[index].getFrecventa(), ButtonType.OK).showAndWait();
    }

    @FXML
    private void on_back() {
        Stage stage = (Stage) butt_back_dif.getScene().getWindow();
        stage.close();
    }
}
