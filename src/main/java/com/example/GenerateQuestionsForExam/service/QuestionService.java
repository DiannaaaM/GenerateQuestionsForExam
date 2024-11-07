package com.example.GenerateQuestionsForExam.service;

import java.util.*;

public interface QuestionService {
    void addQuestion(String question, String answer);
    void removeQuestion(String question);
    Set<String> getQuestions();
    Set<String> getAnswers();
    Map.Entry<String, String> getRandomQuestion();
}
