package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizQuestionRowMapper implements RowMapper<QuizQuestion> {

    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setId(rs.getInt("id"));
        quizQuestion.setQuizId(rs.getInt("quiz_id"));
        quizQuestion.setQuestionId(rs.getInt("question_id"));
        quizQuestion.setSelectedOptionId(rs.getInt("selected_option_id"));
        return quizQuestion;
    }

}
