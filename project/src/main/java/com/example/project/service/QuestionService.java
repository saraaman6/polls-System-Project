package com.example.project.service;

import com.example.project.model.Question;

import java.util.List;

public interface QuestionService {
    Question getQuestionById(Long questionId);
    List<Question>getAllQuestions();
    void createQuestion(Question question);
    Question updateQuestion(Question question);
    void deleteQuestion(Long questionId);

}
