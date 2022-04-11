package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setContent(rs.getString("content"));
        question.setCategoryId(rs.getInt("category_id"));
        return  question;
    }

}
