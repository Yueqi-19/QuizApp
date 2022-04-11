package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.QuizQuestionDao;
import com.beaconfire.quizapp.dao.SubmissionDao;
import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;
import com.beaconfire.quizapp.service.QuizQuestionService;
import com.beaconfire.quizapp.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private SubmissionDao submissionDao;

    @Autowired
    public void setSubmissionDao(SubmissionDao submissionDao) {
        this.submissionDao = submissionDao;
    }

    @Override
    public Integer addSubmission(Submission submission) {
        return submissionDao.addSubmission(submission);
    }
}
