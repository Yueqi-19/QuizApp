package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubmissionRowMapper implements RowMapper<Submission> {

    @Override
    public Submission mapRow(ResultSet rs, int rowNum) throws SQLException {
        Submission submission = new Submission();
        submission.setId(rs.getInt("id"));
        submission.setStartTime(rs.getTimestamp("start_time"));
        submission.setEndTime(rs.getTimestamp("end_time"));
        submission.setScore(rs.getInt("score"));
        submission.setUserId(rs.getInt("user_id"));
        submission.setQuizId(rs.getInt("quiz_id"));
        return submission;
    }

}
