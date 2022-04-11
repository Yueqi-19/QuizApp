package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.CategoryDao;
import com.beaconfire.quizapp.dao.QuestionDao;
import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {

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
    public Question getQuestionById(Integer id) {
        String sql = "SELECT * FROM question WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<Question> questionList = namedParameterJdbcTemplate.query(sql, parameterSource, new QuestionRowMapper());
        return questionList.size() == 0 ? null : questionList.get(0);
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM question";
        List<Question> questionList = namedParameterJdbcTemplate.query(sql, new QuestionRowMapper());
        return questionList;
    }

    @Override
    public List<Question> get10RandomQuestionsByCategoryId(Integer categoryId) {
        String sql = "SELECT * FROM question WHERE category_id = :categoryId ORDER BY RAND() LIMIT 10";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("categoryId", categoryId);
        List<Question> questionList = namedParameterJdbcTemplate.query(sql, parameterSource, new QuestionRowMapper());
        return questionList;
    }

}





