package com.example.project.mapper;

import com.example.project.model.UserAnswer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<UserAnswer> {
    @Override
    public UserAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserAnswer(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("question_id"),
                rs.getString("answer_option")
        );
    }
}
