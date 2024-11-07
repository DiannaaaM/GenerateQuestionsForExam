package com.example.GenerateQuestionsForExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private Set<String> questions;
    private Set<String> answers;

    @Autowired
    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.answers = new HashSet<>();
    }

    @Override
    public void addQuestion(String question, String answer) {
        questions.add(question);
        answers.add(answer);
    }

    @Override
    public void removeQuestion(String question) {

    }

    public void removeQuestion(String question, String answer) {
        questions.remove(question);
        answers.remove(answer);
    }

    @Override
    public Set<String> getQuestions() {
        return questions;
    }

    @Override
    public Set<String> getAnswers() {
        return answers;
    }

    @Override
    public Map.Entry<String, String> getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = Math.floorMod((int) (Math.random() * questions.size()), questions.size());
        List<String> questionList = new ArrayList<>(questions);
        String randomQuestion = questionList.get(randomIndex);
        // Находим соответствующий ответ
        String randomAnswer = answers.stream()
                .filter(answer -> questions.contains(randomQuestion))
                .findFirst()
                .orElse(null);
        return new AbstractMap.SimpleEntry<>(randomQuestion, randomAnswer);
    }
}
