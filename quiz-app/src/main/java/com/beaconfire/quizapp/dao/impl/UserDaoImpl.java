package com.beaconfire.quizapp.dao.impl;

import com.beaconfire.quizapp.dao.UserDao;
import com.beaconfire.quizapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

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
    public User getUserById(Integer id) {
        //String sql = "SELECT * FROM user WHERE id = ?";
        ////User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        ////User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        //User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
        //    User u = new User();
        //    u.setId(rs.getInt("id"));
        //    u.setUsername(rs.getString("username"));
        //    u.setPassword(rs.getString("password"));
        //    u.setFirstName(rs.getString("first_name"));
        //    u.setLastName(rs.getString("last_name"));
        //    u.setEmail(rs.getString("email"));
        //    u.setIsAdmin(rs.getBoolean("is_admin"));
        //    return u;
        //});
        //return user;

        String sql = "SELECT * FROM user WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<User> userList = namedParameterJdbcTemplate.query(sql, parameterSource, new UserRowMapper());
        return userList.size() == 0 ? null : userList.get(0);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = :username AND password = :password";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("username", username);
        parameterSource.addValue("password", password);
        List<User> userList = namedParameterJdbcTemplate.query(sql, parameterSource, new UserRowMapper());
        return userList.size() == 0 ? null : userList.get(0);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> userList = namedParameterJdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    @Override
    public List<User> getUserByIds(List<Integer> idList) {
        String sql = "SELECT * FROM user WHERE id IN (:idList)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idList", idList);
        List<User> userList = namedParameterJdbcTemplate.query(sql, parameterSource, new UserRowMapper());
        return userList;
    }

    @Override
    public List<User> getUserByIdsSet(Set<Integer> idSet) {
        String sql = "SELECT * FROM user WHERE id IN (:idSet)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idSet", idSet);
        List<User> userList = namedParameterJdbcTemplate.query(sql, parameterSource, new UserRowMapper());
        return userList;
    }

    @Override
    public Integer getUserCount() {
        String sql = "SELECT count(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Integer addUser(User user) {
        String sql = "INSERT INTO user (username, password, first_name, last_name, email, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getIsAdmin());
    }
}
