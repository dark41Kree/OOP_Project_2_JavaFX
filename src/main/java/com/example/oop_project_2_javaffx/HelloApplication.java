package com.example.oop_project_2_javaffx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader Fcasa = new FXMLLoader(HelloApplication.class.getResource("Casa_form.fxml"));
        Scene scene = new Scene(Fcasa.load(), 420, 340);
        stage.setTitle("Fereastra pentru initializarea sistemului audio!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}