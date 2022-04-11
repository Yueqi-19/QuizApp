package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.OptionDao;
import com.beaconfire.quizapp.dao.QuestionDao;
import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Question;
import com.beaconfire.quizapp.service.OptionService;
import com.beaconfire.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private OptionDao optionDao;

    @Autowired
    public void setOptionDao(OptionDao optionDao) {
        this.optionDao = optionDao;
    }

    @Override
    public Option getOptionById(Integer id) {
        Option option = optionDao.getOptionById(id);
        return option;
    }

    @Override
    public List<Option> getAllOptions() {
        List<Option> optionList = optionDao.getAllOptions();
        return optionList;
    }

    @Override
    public List<Option> getOptionsByQuestionId(Integer questionId) {
        List<Option> optionList = optionDao.getOptionsByQuestionId(questionId);
        return optionList;
    }

}
