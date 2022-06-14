package com.example.projekt_06_34319;

import java.util.ArrayList;
import java.util.List;

public class Question<list> {
    private String question;
    private List<String> options;
    private String correctAns;


    public Question(String question,  List<String> options, String correctAns) {
        this.question = question;
        this.options= options;
        this.correctAns = correctAns;
    }


    public String getQuestion() {
        return question;
    }

    public List<String> getOptions(){
        return options;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    @Override
    public String toString() {
        return "sample.Question{" +
                "question='" + question + '\'' +
                ", option='" + options + '\'' +
                ", correctAns='" + correctAns + '\'' +
                '}';
    }
}