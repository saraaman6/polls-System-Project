package com.example.project.service;

import com.example.project.model.UserAnswer;
import java.util.List;

public interface UserAnswerService {
    UserAnswer getAnswerById(Long id);
    List<UserAnswer> getAllAnswers();
    void createAnswer(UserAnswer answer);
    UserAnswer updateAnswer(UserAnswer answer);
    void deleteAnswerById(Long id);
    void deleteAnswerByUserId(Long id);
    List<UserAnswer> getAnswersByQuestionId(Long questionId);
    List<UserAnswer> getAnswersByUserId(Long userId);
    Long countAnswersByQuestionId(Long questionId);
    Long countAnswersByUserId(Long userId);
}
