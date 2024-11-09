package com.example.GenerateQuestionsForExam.controller;

import com.example.GenerateQuestionsForExam.service.ExaminerServiceImpl;
import com.example.GenerateQuestionsForExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/exam/get")
public class ExamController {

    @Autowired
    public final ExaminerServiceImpl examinerService;

    public ExamController(QuestionService questionService, ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    public Set<String> getQuestions(@RequestParam("/amount") int amount){
        return examinerService.getRandomQuestions( amount );
    }
}
