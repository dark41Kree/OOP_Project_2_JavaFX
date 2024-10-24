package Controller;

import Interfaces.Close_Window;
import View.Camere_View;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static AudioSystem.AudioSystem.get_System;
import static AudioSystem.AudioSystem.sistem;

public class Audio_System_Controller implements Close_Window {


    @FXML
    private Button Sistem_next_camere;
    @FXML
    private Button button_sistem_form;
    @FXML
    private TextField field_nume_sistem;
    @FXML
    private Label label_nume_sistem;
    @FXML
    private Button butt_close_casa;


    @FXML
    protected void onHelloButtonClick() {

        if (field_nume_sistem.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Introdu numele pentru Sistemul Audio si apasa Next", ButtonType.OK).showAndWait();
        } else {
            get_System(field_nume_sistem.getText());
            new Alert(Alert.AlertType.INFORMATION, "Sistemul Audio a fost creat cu succes!", ButtonType.OK).showAndWait();
            button_sistem_form.setVisible(false);
            field_nume_sistem.setVisible(false);
            label_nume_sistem.setText("Numele Sistemului: " + sistem.getNumeSistem());
            Sistem_next_camere.setVisible(true);
            butt_close_casa.setVisible(true);
        }
    }


    @FXML
    protected void onSistem_next_camere() {
        //Stage stage = (Stage) Sistem_next_camere.getScene().getWindow();
        //stage.close();

        Camere_View.open_Camere_View();

    }

    @FXML
    public void on_back() {
        Stage stage = (Stage) butt_close_casa.getScene().getWindow();
        stage.close();
    }

}