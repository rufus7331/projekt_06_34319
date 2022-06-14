package com.example.projekt_06_34319;
//sprawdz pom jak beda błedy
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Klasa ładująca pytania z csv

public class QuestionLoader {

    public static List<Question> loadQuestions(String filename) {
        List<Question> questions = new ArrayList<Question>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                List<String> options = new ArrayList<String>();
                options.add(values[1]);
                options.add(values[2]);
                options.add(values[3]);
                options.add(values[4]);

                Question question = new Question(values[0], options ,values[5]);
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }
}