package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.service.ExaminerService;
import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        Set<String> expectedQuestions = new HashSet<>();
        expectedQuestions.add("Question 1");
        expectedQuestions.add("Question 2");

        when(javaQuestionService.getQuestions()).thenReturn(expectedQuestions);

        Set<String> result = examinerService.getQuestions();

        assertEquals(expectedQuestions, result);
    }
}
