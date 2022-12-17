module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tp4.rpg to javafx.fxml;
    exports com.tp4.rpg;
}