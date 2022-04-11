package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.Question;

import java.util.List;

public interface QuestionService {

    Question getQuestionById(Integer id);

    List<Question> getAllQuestions();

    List<Question> get10RandomQuestionsByCategoryId(Integer categoryId);

}
