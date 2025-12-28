package com.example.project.mapper;

import com.example.project.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollsMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
               rs.getLong("question_id"),
               rs.getString("question_title"),
               rs.getString("question_first_answer"),
               rs.getString("question_second_answer"),
               rs.getString("question_third_answer"),
               rs.getString("question_fourth_answer")
        );
    }
}
