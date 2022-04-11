package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.QuizQuestionDao;
import com.beaconfire.quizapp.dao.SubmissionDao;
import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("submissionDao")
public class SubmissionDaoImpl implements SubmissionDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer addSubmission(Submission submission) {
        String sql = "INSERT INTO submission (start_time, end_time, score, user_id, quiz_id) VALUE (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, submission.getStartTime(), submission.getEndTime(), submission.getScore(), submission.getUserId(), submission.getQuizId());
    }

}





