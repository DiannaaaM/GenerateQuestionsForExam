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

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    public void testAddQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        Set<String> questions = javaQuestionService.getQuestions();
        assertEquals(1, questions.size());
        assertTrue(questions.contains("What is Java?"));
    }

    @Test
    public void testRemoveQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.removeQuestion("What is Java?", "Java is a programming language." );
        Set<String> questions = javaQuestionService.getQuestions();
        assertEquals(0, questions.size());
        assertFalse(questions.contains("What is Java?"));
    }

    @Test
    public void testGetQuestions() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion("What is Spring?", "Spring is a framework.");
        Set<String> questions = javaQuestionService.getQuestions();
        assertEquals(2, questions.size());
        assertTrue(questions.contains("What is Java?"));
        assertTrue(questions.contains("What is Spring?"));
    }

    @Test
    public void testGetRandomQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion("What is Spring?", "Spring is a framework.");
        Map<String, String> randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
    }
}