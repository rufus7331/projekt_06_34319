package com.example.projekt_06_34319;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.example.projekt_06_34319.SendEmail.isValid;

public class WelcomeView {
    @FXML
    public Button button1;
    @FXML
    public Label text;
    @FXML
    public static TextField email;

    //problem z pobraniem score
  //  int score = Controller.getScore();

    public String getReceiver() {
        return email.getText();
    }

    @FXML
    public void initialize(){
        text.setText("Podaj adres email:");

        button1.setOnAction(event -> {
            try {
                switchToSecondary();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    private static void switchToSecondary() throws IOException {
        Application.setRoot("hello-view");
    }

//    @FXML
//    public void Wyslij(){
//        String email = getReceiver();
//        boolean result = isValid(email);
//        if (result == true) {
//            System.out.println("Provided email address " + email + " is valid \n");
//     )
//        }
//        else{
//            System.out.println("Provided email address " + email + " is invalid \n");
//        }
//    };
}
