package com.beaconfire.quizapp.controller;

import com.beaconfire.quizapp.domain.Quiz;
import com.beaconfire.quizapp.domain.QuizQuestion;
import com.beaconfire.quizapp.domain.Submission;
import com.beaconfire.quizapp.domain.User;
import com.beaconfire.quizapp.service.QuizQuestionService;
import com.beaconfire.quizapp.service.QuizService;
import com.beaconfire.quizapp.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {

    private QuizService quizService;
    private QuizQuestionService quizQuestionService;
    private SubmissionService submissionService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @Autowired
    public void setQuizQuestionService(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @Autowired
    public void setSubmissionService(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("")
    public String resultGet(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Quiz db_quiz = (Quiz) session.getAttribute("db_quiz");
            quizService.addQuiz(db_quiz);
            Integer quizId = quizService.getQuizIdByName(db_quiz.getName());
            //Integer questionNumber = (Integer) session.getAttribute("questionNumber");
            List<QuizQuestion> db_quizQuestionList = (List<QuizQuestion>) session.getAttribute("db_quizQuestionList");
            //db_quizQuestionList.get(questionNumber).setSelectedOptionId(selectedOption.getId());
            for (int i = 0; i < db_quizQuestionList.size(); i++) {
                db_quizQuestionList.get(i).setQuizId(quizId);
                quizQuestionService.addQuizQuestion(db_quizQuestionList.get(i));
            }
            session.setAttribute("db_quizQuestionList", db_quizQuestionList);
            Submission db_submission = (Submission) session.getAttribute("db_submission");
            db_submission.setEndTime(new Timestamp(System.currentTimeMillis()));
            db_submission.setQuizId(quizId);
            db_submission.setScore(quizQuestionService.countCorrectQuizQuestionByQuizId(quizId));
            submissionService.addSubmission(db_submission);
            session.setAttribute("db_submission", db_submission);

            return "result";
        } else {
            return "redirect:/login";
        }
    }
}
