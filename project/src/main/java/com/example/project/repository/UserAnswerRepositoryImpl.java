package com.example.project.repository;

import com.example.project.mapper.AnswerMapper;
import com.example.project.model.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAnswerRepositoryImpl implements UserAnswerRepository {
    private static final String USER_ANSWERS = "user_answers";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserAnswer getAnswerById(Long id) {
        String sql = "SELECT * FROM " + USER_ANSWERS + " WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new AnswerMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserAnswer> getAllAnswers() {
        String sql = "SELECT * FROM " + USER_ANSWERS;
        return jdbcTemplate.query(sql, new AnswerMapper());
    }

    @Override
    public void createAnswer(UserAnswer answer) {
        String sql = "INSERT INTO " + USER_ANSWERS + "(user_id, question_id, answer_option) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, answer.getUserId(), answer.getQuestionId(), answer.getAnswerOption());
    }

    @Override
    public UserAnswer updateAnswer(UserAnswer answer) {
        String sql = "UPDATE " + USER_ANSWERS + " SET user_id = ?, question_id = ?, answer_option = ? WHERE id = ?";
        jdbcTemplate.update(sql, answer.getUserId(), answer.getQuestionId(), answer.getAnswerOption(), answer.getId());
        return answer;
    }

    @Override
    public void deleteAnswerById(Long id) {
        String sql = "DELETE FROM " + USER_ANSWERS + " WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteAnswersByUserId(Long userId) {
        String sql = "DELETE FROM " + USER_ANSWERS + " WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<UserAnswer> findByUserId(Long userId) {
        String sql = "SELECT * FROM " + USER_ANSWERS + " WHERE user_id = ?";
        return jdbcTemplate.query(sql, new AnswerMapper(), userId);
    }

    @Override
    public List<UserAnswer> findByQuestionId(Long questionId) {
        String sql = "SELECT * FROM " + USER_ANSWERS + " WHERE question_id = ?";
        return jdbcTemplate.query(sql, new AnswerMapper(), questionId);
    }

    @Override
    public Long countByUserId(Long userId) {
        String sql = "SELECT COUNT(*) FROM " + USER_ANSWERS + " WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, userId);
    }

    @Override
    public Long countByQuestionId(Long questionId) {
        String sql = "SELECT COUNT(*) FROM " + USER_ANSWERS + " WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, questionId);
    }
}
