package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.User;

import java.util.List;
import java.util.Set;

public interface QuizService {

    Integer addQuiz(Quiz quiz);

    Integer getQuizIdByName(String name);

}
