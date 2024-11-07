package com.example.GenerateQuestionsForExam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public String defaultQuestion() {
        return "Default Question";
    }

    @Bean
    public String defaultAnswer() {
        return "Default Answer";
    }
}
