module com.example.projekt_06_34319 {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;
    requires java.mail;


    opens com.example.projekt_06_34319 to javafx.fxml;
    exports com.example.projekt_06_34319;
}