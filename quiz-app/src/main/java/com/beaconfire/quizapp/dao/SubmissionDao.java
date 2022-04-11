package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;

public interface SubmissionDao {

    Integer addSubmission(Submission submission);

}
