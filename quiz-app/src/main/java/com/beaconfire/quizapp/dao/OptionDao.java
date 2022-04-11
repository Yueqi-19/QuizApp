package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Question;

import java.util.List;

public interface OptionDao {

    Option getOptionById(Integer id);

    List<Option> getAllOptions();

    List<Option> getOptionsByQuestionId(Integer questionId);

}
