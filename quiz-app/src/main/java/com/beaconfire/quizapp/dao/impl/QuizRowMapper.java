package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizRowMapper implements RowMapper<Quiz> {

    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setId(rs.getInt("id"));
        quiz.setName(rs.getString("name"));
        quiz.setCategoryId(rs.getInt("category_id"));
        return quiz;
    }

}
