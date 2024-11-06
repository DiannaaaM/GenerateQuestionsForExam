package com.example.GenerateQuestionsForExam.service;

import com.example.GenerateQuestionsForExam.classes.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QuestionService {
    @Autowired
    private final Question question;

    public QuestionService(Question question) {
        this.question = question;
    }

    public Map<String, String> getRandomQuestions(){
        return (Map<String, String>) question.getRandomQuestion();

    }
}
