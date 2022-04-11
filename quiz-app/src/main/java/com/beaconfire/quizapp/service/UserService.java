package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User getUserById(Integer id);

    User getUserByUsernameAndPassword(String username, String password);

    List<User> getAllUsers();

    void addUser(User user);

    void printUserByIdsList(List<Integer> list);

    void printUserByIdsSet(Set<Integer> set);

    void printUserCount();

    Boolean isUsernamePasswordCorrect(String username, String password);

}
