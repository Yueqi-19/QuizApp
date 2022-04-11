package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.Option;
import com.beaconfire.quizapp.domain.Question;

import java.util.List;

public interface OptionService {

    Option getOptionById(Integer id);

    List<Option> getAllOptions();

    List<Option> getOptionsByQuestionId(Integer questionId);

}
