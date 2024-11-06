package com.example.GenerateQuestionsForExam.service;

import com.example.GenerateQuestionsForExam.classes.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.example.GenerateQuestionsForExam.classes.Question;

@Service
public class JavaQuestionService {
    private List<String> questions;
    private List<String> answers;

    @Autowired
    private final Question questionCl;

    public JavaQuestionService(Question questionCl) {
        this.questionCl = questionCl;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public void addQuestion(String question, String answer) {
        questions.add(question);
        answers.add(answer);
        questionCl.addQuestion(question, answer);
    }

    public void removeQuestion(String question, String answer) {
        questions.remove(question);
        answers.remove(answer);
        questionCl.removeQuestion(question);
    }

    public Map<String, String> getQuestions(){
        return questionCl.getQuestions();
    }
    public List<String> getAnswers(){
        return answers;
    }
}
