package com.example.project.repository;

import com.example.project.mapper.PollsMapper;
import com.example.project.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    private static final String POLLS_TABLE = "polls";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Question getQuestionById(Long id) {
        String sql = "SELECT * FROM " + POLLS_TABLE + " WHERE question_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollsMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM " + POLLS_TABLE;
        return jdbcTemplate.query(sql, new PollsMapper());
    }

    @Override
    public void createQuestion(Question polls) {
        String sql = "INSERT INTO " + POLLS_TABLE +
                "(question_title, question_first_answer, question_second_answer, question_third_answer, question_fourth_answer) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, polls.getQuestion_title(), polls.getQuestion_first_answer(),
                polls.getQuestion_second_answer(), polls.getQuestion_third_answer(), polls.getQuestion_fourth_answer());
    }

    @Override
    public Question updateQuestion(Question polls) {
        String sql = "UPDATE " + POLLS_TABLE +
                " SET question_title = ?, question_first_answer = ?, question_second_answer = ?, question_third_answer = ?, question_fourth_answer = ? WHERE question_id = ?";
        jdbcTemplate.update(sql, polls.getQuestion_title(), polls.getQuestion_first_answer(),
                polls.getQuestion_second_answer(), polls.getQuestion_third_answer(), polls.getQuestion_fourth_answer(),
                polls.getQuestion_id());
        return polls;
    }

    @Override
    public void deleteQuestion(Long id) {
        String sql = "DELETE FROM " + POLLS_TABLE + " WHERE question_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
