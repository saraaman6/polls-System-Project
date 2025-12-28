package com.example.project.service;

import com.example.project.client.UserClient;
import com.example.project.model.UserAnswer;
import com.example.project.repository.UserAnswerRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    private UserClient userClient;

    @Override
    public UserAnswer getAnswerById(Long id) {
        return userAnswerRepository.getAnswerById(id);
    }

    @Override
    public List<UserAnswer> getAllAnswers() {
        return userAnswerRepository.getAllAnswers();
    }

    @Override
    public void createAnswer(UserAnswer answer) {
        try {
            userClient.getUserById(answer.getUserId());
            userAnswerRepository.createAnswer(answer);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("User not registered");
        }
    }

    @Override
    public UserAnswer updateAnswer(UserAnswer answer) {
        return userAnswerRepository.updateAnswer(answer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        userAnswerRepository.deleteAnswerById(id);
    }

    @Override
    public void deleteAnswerByUserId(Long userId) {
        try {
            userClient.getUserById(userId);
            throw new RuntimeException("User still exists, cannot delete answers");
        } catch (FeignException.NotFound e) {
            userAnswerRepository.deleteAnswersByUserId(userId);
        }
    }

    @Override
    public List<UserAnswer> getAnswersByQuestionId(Long questionId) {
        return userAnswerRepository.findByQuestionId(questionId);
    }

    @Override
    public List<UserAnswer> getAnswersByUserId(Long userId) {
        return userAnswerRepository.findByUserId(userId);
    }

    @Override
    public Long countAnswersByQuestionId(Long questionId) {
        return userAnswerRepository.countByQuestionId(questionId);
    }

    @Override
    public Long countAnswersByUserId(Long userId) {
        return userAnswerRepository.countByUserId(userId);
    }
}
