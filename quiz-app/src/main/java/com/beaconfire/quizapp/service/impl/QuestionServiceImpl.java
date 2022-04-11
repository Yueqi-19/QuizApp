package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.CategoryDao;
import com.beaconfire.quizapp.dao.QuestionDao;
import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.Question;
import com.beaconfire.quizapp.service.CategoryService;
import com.beaconfire.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Question getQuestionById(Integer id) {
        Question question = questionDao.getQuestionById(id);
        return question;
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questionList = questionDao.getAllQuestions();
        return questionList;
    }

    @Override
    public List<Question> get10RandomQuestionsByCategoryId(Integer categoryId) {
        List<Question> questionList = questionDao.get10RandomQuestionsByCategoryId(categoryId);
        return questionList;
    }

}
