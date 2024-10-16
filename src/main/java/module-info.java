module com.example.oop_project_2_javaffx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.oop_project_2_javaffx to javafx.fxml;
    exports com.example.oop_project_2_javaffx;
}