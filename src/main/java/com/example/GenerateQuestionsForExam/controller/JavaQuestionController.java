package com.example.GenerateQuestionsForExam.controller;

import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @Autowired
    private JavaQuestionService javaQuestionService;

    @GetMapping
    public String seeQuestions(){
        return "<p>" + javaQuestionService.getQuestions() + "</p>";
    }

    @GetMapping("/add")
    public String addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        javaQuestionService.addQuestion(question, answer);
        return "<p>" + "question successfully was added!" + "</p>";
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        javaQuestionService.removeQuestion(question, answer);
        return "<p>" + "question successfully was removed!" + "</p>";
    }



}
