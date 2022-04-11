package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.UserDao;
import com.beaconfire.quizapp.domain.User;
import com.beaconfire.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Integer id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userDao.getAllUsers();
        return  userList;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void printUserByIdsList(List<Integer> list) {
        List<User> userList = userDao.getUserByIds(list);
        userList.forEach(System.out::println);
    }

    @Override
    public void printUserByIdsSet(Set<Integer> set) {
        List<User> userList = userDao.getUserByIdsSet(set);
        userList.forEach(System.out::println);
    }

    @Override
    public void printUserCount() {
        System.out.println(userDao.getUserCount());
    }

    @Override
    public Boolean isUsernamePasswordCorrect(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        //return user != null? true : false;
        return user != null;
    }

}
