package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.OptionDao;
import com.beaconfire.quizapp.dao.QuizDao;
import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quizDao")
public class QuizDaoImpl implements QuizDao {

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
    public Quiz getQuizById(Integer id) {
        String sql = "SELECT * FROM quiz WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<Quiz> quizList = namedParameterJdbcTemplate.query(sql, parameterSource, new QuizRowMapper());
        return quizList.size() == 0 ? null : quizList.get(0);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        String sql = "SELECT * FROM quiz";
        List<Quiz> quizList = namedParameterJdbcTemplate.query(sql, new QuizRowMapper());
        return quizList;
    }

    @Override
    public Integer addQuiz(Quiz quiz) {
        String sql = "INSERT INTO quiz (name, category_id) VALUE (?, ?)";
        return jdbcTemplate.update(sql, quiz.getName(), quiz.getCategoryId());
    }

    @Override
    public Integer getQuizIdByName(String name) {
        String sql = "SELECT * FROM quiz WHERE name = :name";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", name);
        List<Quiz> quizList = namedParameterJdbcTemplate.query(sql, parameterSource, new QuizRowMapper());
        return quizList.size() == 0 ? null : quizList.get(0).getId();
    }


}





