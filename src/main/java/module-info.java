module com.example.oop_project_2_javaffx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens Controller to javafx.fxml;
    exports Controller;

    exports View to javafx.graphics;

}

