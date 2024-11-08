package com.example.GenerateQuestionsForExam.service;

import com.example.GenerateQuestionsForExam.Exeptions.BAD_REQUEST;
import com.example.GenerateQuestionsForExam.classes.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl {

    @Autowired
    private final QuestionService questionService;
    private Set<Question> questions;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<Question> getRandomQuestions(int numQuestions) {
        if (numQuestions > questionService.getQuestions().size()) {
            throw new BAD_REQUEST("Слишком большой запрос для количества вопросов");
        } else {
            Set<Question> randomQuestions = new HashSet<>();
            while (randomQuestions.size() < numQuestions) {
                Map<String, String> questionData = questionService.getRandomQuestion();
                String questionText = questionData.keySet().iterator().next();
                String answer = questionData.get(questionText);
                Question question = new Question(questionText, answer);
                randomQuestions.add(question);
            }
            return randomQuestions;
        }
    }
}

