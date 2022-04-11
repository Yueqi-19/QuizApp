package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionRowMapper implements RowMapper<Option> {

    @Override
    public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
        Option option = new Option();
        option.setId(rs.getInt("id"));
        option.setContent(rs.getString("content"));
        option.setQuestionId(rs.getInt("question_id"));
        option.setIsCorrect(rs.getBoolean("is_correct"));
        return option;
    }

}
