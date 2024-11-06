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
    private final Question question;
    private Set<Question> questions;

    public ExaminerServiceImpl(QuestionService questionService, Question question) {
        this.questionService = questionService;
        this.question = question;
        this.questions = new HashSet<>();
    }

    public Set<Question> getRandomQuestions(int numQuestions) {
        if (numQuestions > question.getQuestions().size()) {
            throw new BAD_REQUEST( "Too large request for number of questions" );
        } else {
            while (questions.size() < numQuestions) {
                Map<String, String> question = questionService.getRandomQuestions();
                questions.add( (Question) question.keySet() );
            }
        }
        return questions;
    }
}

