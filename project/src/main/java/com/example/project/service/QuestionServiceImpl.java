package com.example.project.service;

import com.example.project.model.Question;
import com.example.project.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.getQuestionById(id);
    }


    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public void createQuestion(Question question) {
        questionRepository.createQuestion(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.updateQuestion(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteQuestion(id);
    }

}
