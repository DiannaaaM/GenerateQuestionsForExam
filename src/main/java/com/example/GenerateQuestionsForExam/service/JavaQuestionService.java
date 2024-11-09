package com.example.GenerateQuestionsForExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private Set<String> questions;
        int nextId = 1;
    private Random rand = new Random();

    @Autowired
    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public void addQuestion(String question, String answer) {
        questions.add(question);
        nextId++;
    }

    @Override
    public void removeQuestion(String question) {
        questions.remove(question);
        nextId--;
    }

    public void removeQuestion(String question, String answer) {
        questions.remove(question);
    }

    @Override
    public Set<String> getQuestions() {
        return questions;
    }

    @Override
    public Set<String> getAnswers() {
        return Set.of();
    }


    @Override
    public String getRandomQuestion() {
        return new ArrayList<>(questions).get( rand.nextInt(questions.size()));
    }
}
