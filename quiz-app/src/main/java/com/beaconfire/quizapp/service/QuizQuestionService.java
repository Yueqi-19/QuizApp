package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;

import java.util.List;

public interface QuizQuestionService {

    Integer addQuizQuestion(QuizQuestion quizQuestion);

    Integer countCorrectQuizQuestionByQuizId(Integer quizId);
}
