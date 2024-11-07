package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

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
        Map<String, String> questions = javaQuestionService.getQuestions();
        assertEquals(1, questions.size());
        assertTrue(questions.containsKey("What is Java?"));
        assertEquals("Java is a programming language.", questions.get("What is Java?"));
    }

    @Test
    public void testRemoveQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.removeQuestion("What is Java?", "Java is a programming language." );
        Map<String, String> questions = javaQuestionService.getQuestions();
        assertEquals(1, questions.size());
    }

    @Test
    public void testGetQuestions() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion("What is Spring?", "Spring is a framework.");
        Map<String, String> questions = javaQuestionService.getQuestions();
        assertEquals(2, questions.size());
        assertTrue(questions.containsKey("What is Java?"));
        assertTrue(questions.containsKey("What is Spring?"));
    }

    @Test
    public void testGetRandomQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion("What is Spring?", "Spring is a framework.");
        Map.Entry<String, String> randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(javaQuestionService.getQuestions().containsKey(randomQuestion.getKey()));
    }
}