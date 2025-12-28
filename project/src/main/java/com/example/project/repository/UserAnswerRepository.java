package com.example.project.repository;

import com.example.project.model.UserAnswer;
import java.util.List;

public interface UserAnswerRepository {
    UserAnswer getAnswerById(Long id);
    List<UserAnswer> getAllAnswers();
    void createAnswer(UserAnswer answer);
    UserAnswer updateAnswer(UserAnswer answer);
    public void deleteAnswerById(Long id);
    public void deleteAnswersByUserId(Long id);
    List<UserAnswer> findByUserId(Long userId);
    List<UserAnswer> findByQuestionId(Long questionId);
    Long countByUserId(Long userId);
    Long countByQuestionId(Long questionId);
}
