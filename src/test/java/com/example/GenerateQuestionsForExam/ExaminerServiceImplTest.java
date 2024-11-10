package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.service.ExaminerService;
import com.example.GenerateQuestionsForExam.service.ExaminerServiceImpl;
import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import com.example.GenerateQuestionsForExam.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetRandomQuestions() {
        Set<String> questions = new HashSet<>();
        questions.add("Question 1");
        questions.add("Question 2");
        questions.add("Question 3");
        when(questionService.getQuestions()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn("Question 1", "Question 2", "Question 3");

        Set<String> randomQuestions = examinerService.getRandomQuestions(2);
        assertEquals(2, randomQuestions.size());
        assertTrue(randomQuestions.contains("Question 1"));
        assertTrue(randomQuestions.contains("Question 2"));
    }

    @Test
    public void testGetRandomQuestions_TooManyQuestions() {
        Set<String> questions = new HashSet<>();
        questions.add("Question 1");
        questions.add("Question 2");
        when(questionService.getQuestions()).thenReturn(questions);

        assertThrows(IllegalArgumentException.class, () -> examinerService.getRandomQuestions(3));
    }
}
