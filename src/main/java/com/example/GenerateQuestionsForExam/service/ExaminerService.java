package com.example.GenerateQuestionsForExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExaminerService {

    @Autowired
    private final JavaQuestionService javaQuestionService;

    public ExaminerService(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    public Map<String, String> getQuestions(){
        return javaQuestionService.getQuestions();
    }
}
