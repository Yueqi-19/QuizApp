package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    User getUserById(Integer id);

    User getUserByUsernameAndPassword(String username, String password);

    List<User> getAllUsers();

    List<User> getUserByIds(List<Integer> idList);

    List<User> getUserByIdsSet(Set<Integer> idSet);

    Integer getUserCount();

    Integer addUser(User user);

}
