package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.QuizDao;
import com.beaconfire.quizapp.dao.QuizQuestionDao;
import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quizQuestionDao")
public class QuizQuestionDaoImpl implements QuizQuestionDao {

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
    public Integer addQuizQuestion(QuizQuestion quizQuestion) {
        String sql = "INSERT INTO quiz_question (quiz_id, question_id, selected_option_id) VALUE (?, ?, ?)";
        return jdbcTemplate.update(sql, quizQuestion.getQuizId(), quizQuestion.getQuestionId(), quizQuestion.getSelectedOptionId());
    }

    @Override
    public List<QuizQuestion> getCorrectQuizQuestionByQuizId(Integer quizId) {
        String sql = "SELECT * FROM quiz_question qq LEFT JOIN `option` o ON qq.selected_option_id = o.id WHERE qq.quiz_id = :quizId AND o.is_correct = true";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("quizId", quizId);
        List<QuizQuestion> quizQuestionList = namedParameterJdbcTemplate.query(sql, parameterSource, new QuizQuestionRowMapper());
        return quizQuestionList;
    }

}





