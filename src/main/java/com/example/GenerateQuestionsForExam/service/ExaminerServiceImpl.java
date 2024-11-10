package com.example.GenerateQuestionsForExam.service;

import com.example.GenerateQuestionsForExam.classes.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl {

    @Autowired
    private final QuestionService questionService;
    private Set<Question> questions;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<String> getRandomQuestions(int numQuestions) {
        if (numQuestions > questionService.getQuestions().size()) {
            throw new IllegalArgumentException("Слишком большой запрос для количества вопросов");
        } else {
            Set<String> randomQuestions = new HashSet<>();
            while (randomQuestions.size() < numQuestions) {
                String question = questionService.getRandomQuestion();
                randomQuestions.add(question);
            }
            return randomQuestions;
        }
    }
}
