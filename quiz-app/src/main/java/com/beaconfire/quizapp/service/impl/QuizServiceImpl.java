package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.OptionDao;
import com.beaconfire.quizapp.dao.QuizDao;
import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.service.OptionService;
import com.beaconfire.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizDao quizDao;

    @Autowired
    public void setQuizDao(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    @Override
    public Integer addQuiz(Quiz quiz) {
        return quizDao.addQuiz(quiz);
    }

    @Override
    public Integer getQuizIdByName(String name) {
        return quizDao.getQuizIdByName(name);
    }
}
