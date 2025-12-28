package com.example.project.repository;

import com.example.project.model.Question;
import java.util.List;

public interface QuestionRepository {
    Question getQuestionById(Long questionId);
    List<Question> getAllQuestions();
    void createQuestion(Question poll);
    Question updateQuestion(Question polls);
    void deleteQuestion(Long questionId);

}
