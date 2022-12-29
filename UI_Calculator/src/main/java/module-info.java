module com.example.ui_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ui_calculator to javafx.fxml;
    exports com.example.ui_calculator;
}