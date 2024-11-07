package com.example.GenerateQuestionsForExam.service;

import java.util.*;

public interface QuestionService {
    void addQuestion(String question, String answer);

    void removeQuestion(String question, String answer);

    void removeQuestion(String question);
    Map<String, String> getQuestions();
    Map.Entry<String, String> getRandomQuestion();
}
