package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void testAddQuestion() {
        javaQuestionService.addQuestion("Question 1", "Answer 1");
        assertEquals(1, javaQuestionService.getQuestions().size());
    }

    @Test
    public void testRemoveQuestion() {
        javaQuestionService.addQuestion("Question 1", "Answer 1");
        javaQuestionService.removeQuestion("Question 1");
        assertEquals(0, javaQuestionService.getQuestions().size());
    }

    @Test
    public void testGetRandomQuestion() {
        javaQuestionService.addQuestion("Question 1", "Answer 1");
        javaQuestionService.addQuestion("Question 2", "Answer 2");
        String question = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getQuestions().contains(question));
    }

    @Test
    public void testGetQuestions() {
        javaQuestionService.addQuestion("Question 1", "Answer 1");
        javaQuestionService.addQuestion("Question 2", "Answer 2");
        Set<String> questions = javaQuestionService.getQuestions();
        assertEquals(2, questions.size());
        assertTrue(questions.contains("Question 1"));
        assertTrue(questions.contains("Question 2"));
    }

    @Test
    public void testGetAnswers() {
        Set<String> answers = javaQuestionService.getAnswers();
        assertEquals(0, answers.size());
        assertEquals(0, answers.size());
    }
}