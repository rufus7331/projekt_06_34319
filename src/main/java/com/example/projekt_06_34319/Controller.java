package com.example.projekt_06_34319;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Controller {
    public BorderPane pane;
    @FXML
    public Label result;
    @FXML
    private Label questionLabel;
    @FXML
    private ToggleGroup optionsGroup;
    @FXML
    private Button submitButton;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;
    int currentQuestion=0;
    @FXML
    int score =0;

    @FXML
    public void initialize(){
        List<Question> questions = QuestionLoader.loadQuestions("Questions.csv");
        Collections.shuffle(questions);

        questionLabel.setText(((Question)questions.get(currentQuestion)).getQuestion());
        String option1 = (String)questions.get(currentQuestion).getOptions().get(0);
        String option2 = (String)questions.get(currentQuestion).getOptions().get(1);
        String option3 = (String)questions.get(currentQuestion).getOptions().get(2);
        String option4 = (String)questions.get(currentQuestion).getOptions().get(3);

        rb1.setText(option1);
        rb2.setText(option2);
        rb3.setText(option3);
        rb4.setText(option4);
        submitButton.setText("Następne pytanie");
        result.setText(" ");


        submitButton.setOnAction(event -> getNextQuestion(questions));

    }

    private void getNextQuestion(List<Question> questions) {
        submitButton.setText("Następne pytanie");


        if (currentQuestion<questions.size()) {
            String selectedRB = ((RadioButton)optionsGroup.getSelectedToggle()).getText();
            String correctAnswer = (String)questions.get(currentQuestion).getCorrectAns();
            if (selectedRB.equals(correctAnswer) ){
                score++;
                System.out.println("Poprawna odpowiedź");
            }
            else {
                System.out.println("Błędna odpowiedź");
            }
            currentQuestion++;
            if(currentQuestion<questions.size()){
                questionLabel.setText(questions.get(currentQuestion).getQuestion());
                String option1 = (String)questions.get(currentQuestion).getOptions().get(0);
                String option2 = (String)questions.get(currentQuestion).getOptions().get(1);
                String option3 = (String)questions.get(currentQuestion).getOptions().get(2);
                String option4 = (String)questions.get(currentQuestion).getOptions().get(3);

                rb1.setText(option1);
                rb2.setText(option2);
                rb3.setText(option3);
                rb4.setText(option4);
            }
            else{
                switch (score){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        questionLabel.setText("Ocena: 2.0 ");
                        break;
                    case 5:
                    case 6:
                        questionLabel.setText("Ocena: 3.0");
                        break;
                    case 7:
                        questionLabel.setText("Ocena: 3.5");
                        break;
                    case 8:
                        questionLabel.setText("Ocena: 4.0");
                        break;
                    case 9:
                        questionLabel.setText("Ocena: 4.5");
                        break;
                    case 10:
                        questionLabel.setText("Ocena: 5.0");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + score);
                }
                rb1.setText("");
                rb2.setText("");
                rb3.setText("");
                rb4.setText("");
                result.setText("Zdobyte punkty: " +score);
                submitButton.setText("Zakończ");
            }
        }

        else {
            System.exit(0);
        }
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);

    }
}