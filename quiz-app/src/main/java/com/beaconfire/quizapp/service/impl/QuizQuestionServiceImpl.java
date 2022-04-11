package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.QuizDao;
import com.beaconfire.quizapp.dao.QuizQuestionDao;
import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.service.QuizQuestionService;
import com.beaconfire.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {

    private QuizQuestionDao quizQuestionDao;

    @Autowired
    public void setQuizQuestionDao(QuizQuestionDao quizQuestionDao) {
        this.quizQuestionDao = quizQuestionDao;
    }

    @Override
    public Integer addQuizQuestion(QuizQuestion quizQuestion) {
        return quizQuestionDao.addQuizQuestion(quizQuestion);
    }

    @Override
    public Integer countCorrectQuizQuestionByQuizId(Integer quizId) {
        List<QuizQuestion> quizQuestionList = quizQuestionDao.getCorrectQuizQuestionByQuizId(quizId);
        return quizQuestionList.size();
    }
}
