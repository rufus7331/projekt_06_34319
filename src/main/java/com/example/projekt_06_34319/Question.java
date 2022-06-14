package com.example.projekt_06_34319;

import java.util.List;

public class Question<list> {
    private final String question;
    private final List<String> options;
    private final String correctAns;


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
        return "Question{" +
                "question='" + question + '\'' +
                ", option='" + options + '\'' +
                ", correctAns='" + correctAns + '\'' +
                '}';
    }
}