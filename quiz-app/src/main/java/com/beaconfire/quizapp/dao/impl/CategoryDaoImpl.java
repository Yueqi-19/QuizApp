package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.CategoryDao;
import com.beaconfire.quizapp.dao.UserDao;
import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

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
    public Category getCategoryById(Integer id) {
        String sql = "SELECT * FROM category WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<Category> categoryList = namedParameterJdbcTemplate.query(sql, parameterSource, new CategoryRowMapper());
        return categoryList.size() == 0 ? null : categoryList.get(0);
    }

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM category";
        List<Category> categoryList = namedParameterJdbcTemplate.query(sql, new CategoryRowMapper());
        return categoryList;
    }

}
