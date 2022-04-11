package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;

public interface SubmissionService {

    Integer addSubmission(Submission submission);

}
