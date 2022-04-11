package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.Question;

import java.util.List;

public interface QuestionDao {

    Question getQuestionById(Integer id);

    List<Question> getAllQuestions();

    List<Question> get10RandomQuestionsByCategoryId(Integer categoryId);

}
