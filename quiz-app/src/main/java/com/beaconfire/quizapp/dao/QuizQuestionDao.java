package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;

import java.util.List;

public interface QuizQuestionDao {

    Integer addQuizQuestion(QuizQuestion quizQuestion);

    List<QuizQuestion> getCorrectQuizQuestionByQuizId(Integer quizId);
}
