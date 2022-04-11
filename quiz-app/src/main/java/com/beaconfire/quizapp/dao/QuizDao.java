package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.User;

import java.util.List;

public interface QuizDao {

    Quiz getQuizById(Integer id);

    List<Quiz> getAllQuizzes();

    Integer addQuiz(Quiz quiz);

    Integer getQuizIdByName(String name);
}
