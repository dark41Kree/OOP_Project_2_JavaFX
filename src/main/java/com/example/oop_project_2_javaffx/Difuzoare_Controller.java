package com.example.oop_project_2_javaffx;

import AudioSystem.Camera;
import AudioSystem.Difuzor;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

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
        if(camera.nrdifuzoare<=4) {
            getPozitiesiFrecventa();
        } else new Alert(Alert.AlertType.INFORMATION,"Aveti deja nr. maxim de difuzoare in camera care este 5 !" , ButtonType.OK).showAndWait();
        afiseazaDifuzoare();

    }

    @FXML
    protected void on_sterge_difuzor() {
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

    public void afiseazaDifuzoare(){
        if(camera.nrdifuzoare>0) {
            StringBuilder info = new StringBuilder();

            for (int i = 0; i < sistem.nrcamere; i++) {
                info.append("Difuzor ")
                        .append(i + 1)
                        .append(": Poziție = ").append(camera.difuzor[i].getPozitie())
                        .append(", Frecvență = ").append(camera.difuzor[i].getFrecventa())
                        .append("\n");
            }
            //new Alert(Alert.AlertType.INFORMATION, info.toString() , ButtonType.OK).showAndWait();
            Platform.runLater(() -> difuzoare_label.setText(info.toString()));
            //difuzoare_label.setAccessibleText(info.toString());
        }
    }





}
