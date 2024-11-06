package com.example.GenerateQuestionsForExam;

import com.example.GenerateQuestionsForExam.classes.Question;
import com.example.GenerateQuestionsForExam.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private Question question;

    @BeforeEach
    void setUp() {
        question = mock( Question.class );
        javaQuestionService = new JavaQuestionService( question );
    }

    @Test
    void addQuestion() {
        // Mock the behavior of question.addQuestion
        doNothing().when( question ).addQuestion( "Question 1", "Answer 1" );

        // Call the addQuestion method
        javaQuestionService.addQuestion( "Question 1", "Answer 1" );

        // Verify that the question was added to the question class
        verify( question, times( 1 ) ).addQuestion( "Question 1", "Answer 1" );
    }

    @Test
    void removeQuestion() {
        // Mock the behavior of question.removeQuestion
        doNothing().when( question ).removeQuestion( "Question 1" );

        // Call the removeQuestion method
        javaQuestionService.removeQuestion( "Question 1", "Answer 1" );

        // Verify that the question was removed from the question class
        verify( question, times( 1 ) ).removeQuestion( "Question 1" );
    }
}