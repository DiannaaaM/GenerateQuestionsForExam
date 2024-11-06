package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.service.ExaminerService;
import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerService examinerService;

    @Test
    public void getQuestions_Success() {
        Map<String, String> expectedQuestions = new HashMap<>();
        expectedQuestions.put("Question 1", "Answer 1");
        expectedQuestions.put("Question 2", "Answer 2");

        when(javaQuestionService.getQuestions()).thenReturn(expectedQuestions);

        Map<String, String> result = examinerService.getQuestions();

        assertEquals(expectedQuestions, result);
    }
}
