package Controller;


import AudioSystem.Camera;
import Interfaces.Close_Window;
import View.Difuzoare_View;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

import static AudioSystem.AudioSystem.sistem;

public class Camere_Controller implements Close_Window {


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
    private Button butt_back_cam;

    @FXML
    public void setLabel_nume_sistem() {
        label_nume_sistem.setText(sistem.getNumeSistem());
        if (sistem.camera[0] != null) {
            butt_cam_2.setDisable(false);
        }
        if (sistem.camera[1] != null) {
            butt_cam_3.setDisable(false);
        }
        if (sistem.camera[2] != null) {
            butt_cam_4.setDisable(false);
        }
        if (sistem.camera[3] != null) {
            butt_cam_5.setDisable(false);
        }
        if (sistem.camera[4] != null) {
            butt_cam_6.setDisable(false);
        }
        if (sistem.camera[5] != null) {
            butt_cam_7.setDisable(false);
        }
        if (sistem.camera[6] != null) {
            butt_cam_8.setDisable(false);
        }
        if (sistem.camera[7] != null) {
            butt_cam_9.setDisable(false);
        }
        if (sistem.camera[8] != null) {
            butt_cam_10.setDisable(false);
        }
    }


    @FXML
    private void on_butt_cam_1() {
        if (sistem.camera[0] == null) {
            getNumesiVolum();
            if (sistem.camera[0] != null) {
                butt_cam_2.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 0);
        }
    }

    @FXML
    private void on_butt_cam_2() {
        if (sistem.camera[1] == null) {
            getNumesiVolum();
            if (sistem.camera[1] != null) {
                butt_cam_3.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 1);
        }
    }

    @FXML
    private void on_butt_cam_3() {
        if (sistem.camera[2] == null) {
            getNumesiVolum();
            if (sistem.camera[2] != null) {
                butt_cam_4.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 2);
        }
    }

    @FXML
    private void on_butt_cam_4() {
        if (sistem.camera[3] == null) {
            getNumesiVolum();
            if (sistem.camera[3] != null) {
                butt_cam_5.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 3);
        }
    }

    @FXML
    private void on_butt_cam_5() {
        if (sistem.camera[4] == null) {
            getNumesiVolum();
            if (sistem.camera[4] != null) {
                butt_cam_6.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 4);
        }
    }

    @FXML
    private void on_butt_cam_6() {
        if (sistem.camera[5] == null) {
            getNumesiVolum();
            if (sistem.camera[5] != null) {
                butt_cam_7.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 5);
        }
    }

    @FXML
    private void on_butt_cam_7() {
        if (sistem.camera[6] == null) {
            getNumesiVolum();
            if (sistem.camera[6] != null) {
                butt_cam_8.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 6);
        }
    }

    @FXML
    private void on_butt_cam_8() {
        if (sistem.camera[7] == null) {
            getNumesiVolum();
            if (sistem.camera[7] != null) {
                butt_cam_9.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 7);
        }
    }

    @FXML
    private void on_butt_cam_9() {
        if (sistem.camera[8] == null) {
            getNumesiVolum();
            if (sistem.camera[8] != null) {
                butt_cam_10.setDisable(false);
            }
        } else {
            deschide_form_difuzoare(sistem.camera, 8);
        }
    }

    @FXML
    private void on_butt_cam_10() {
        if (sistem.camera[9] == null) {
            getNumesiVolum();
        } else {
            deschide_form_difuzoare(sistem.camera, 9);
        }
    }

    private void getNumesiVolum() {
        TextInputDialog dialogNume = new TextInputDialog();
        dialogNume.setTitle("Nume Cameră");
        dialogNume.setHeaderText("Introduceți numele pentru camera " + (sistem.nrcamere + 1));
        dialogNume.setContentText("Nume Cameră:");

        Optional<String> resultNume = dialogNume.showAndWait();
        if (resultNume.get().equals("") || resultNume.get().isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Nume cameră invalid!", ButtonType.OK).showAndWait();
            return;
        }
        String nume = resultNume.get();

        TextInputDialog dialogVolum = new TextInputDialog();
        dialogVolum.setTitle("Volum Cameră");
        dialogVolum.setHeaderText("Introduceți volumul pentru camera " + (sistem.nrcamere + 1));
        dialogVolum.setContentText("Volum Cameră (0 - 100):");

        Optional<String> resultVolum = dialogVolum.showAndWait();
        if (!resultVolum.isPresent() || resultVolum.get().isEmpty()) {
            return;
        }

        int volumCamera;
        try {
            volumCamera = Integer.parseInt(resultVolum.get());
            if (volumCamera < 0 || volumCamera > 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Volum invalid! Introduceți un număr întreg între 0 și 100.", ButtonType.OK).showAndWait();
            return;
        }
        sistem.addcamera(nume, volumCamera);


    }


    private void deschide_form_difuzoare(Camera[] arrayCamere, int index) {

        Difuzoare_View.open_Difuzoare_View(arrayCamere, index);

    }

    @FXML
    public void on_back() {
        Stage stage = (Stage) butt_back_cam.getScene().getWindow();
        stage.close();
    }
}
