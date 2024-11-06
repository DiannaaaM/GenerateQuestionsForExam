package com.example.GenerateQuestionsForExam.classes;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Question {
    private Map<String, String> questions;

    public Question() {
        questions = new HashMap<>();
        questions.put("Столица Франци это...", "Париж");
        questions.put("Кто написал 'Война и мир'?", "Толстой");
        questions.put("Как переводится слово'Laptop' с английского?", "Ноутбук");
    }
    public void addQuestion(String question, String answer) {
        questions.put(question, answer);
    }
    public void removeQuestion(String question) {
        questions.remove(question);
    }

    public Map<String, String> getQuestions() {
        return questions;
    }

    public Map.Entry<String, String> getRandomQuestion() {
        int randomIndex = Math.floorMod((int) (Math.random() * questions.size()), questions.size());

        List<Map.Entry<String, String>> questionEntries = new ArrayList<>(questions.entrySet());
        return questionEntries.get(randomIndex);
    }
}
