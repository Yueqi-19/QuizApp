package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.OptionDao;
import com.beaconfire.quizapp.dao.QuestionDao;
import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("optionDao")
public class OptionDaoImpl implements OptionDao {

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
    public Option getOptionById(Integer id) {
        String sql = "SELECT * FROM option WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<Option> optionList = namedParameterJdbcTemplate.query(sql, parameterSource, new OptionRowMapper());
        return optionList.size() == 0 ? null : optionList.get(0);
    }

    @Override
    public List<Option> getAllOptions() {
        String sql = "SELECT * FROM option";
        List<Option> optionList = namedParameterJdbcTemplate.query(sql, new OptionRowMapper());
        return optionList;
    }

    @Override
    public List<Option> getOptionsByQuestionId(Integer questionId) {
        String sql = "SELECT * FROM `option` WHERE question_id = :questionId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("questionId", questionId);
        List<Option> optionList = namedParameterJdbcTemplate.query(sql, parameterSource, new OptionRowMapper());
        return optionList;
    }

}





