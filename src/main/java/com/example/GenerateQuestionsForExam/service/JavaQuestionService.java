package com.example.GenerateQuestionsForExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Map<String, String> questions;

    @Autowired
    public JavaQuestionService() {
        this.questions = new HashMap<>();
    }

    @Override
    public void addQuestion(String question, String answer) {
        questions.put(question, answer);
    }

    @Override
    public void removeQuestion(String question, String answer) {

    }

    @Override
    public void removeQuestion(String question) {
        questions.remove(question);
    }

    @Override
    public Map<String, String> getQuestions() {
        return questions;
    }

    @Override
    public Map.Entry<String, String> getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = Math.floorMod((int) (Math.random() * questions.size()), questions.size());
        List<Map.Entry<String, String>> questionEntries = new ArrayList<>(questions.entrySet());
        return questionEntries.get(randomIndex);
    }
}
