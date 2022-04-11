package com.beaconfire.quizapp.controller;

import com.beaconfire.quizapp.domain.*;
import com.beaconfire.quizapp.service.CategoryService;
import com.beaconfire.quizapp.service.OptionService;
import com.beaconfire.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private CategoryService categoryService;
    private QuestionService questionService;
    private OptionService optionService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setOptionService(OptionService optionService) {
        this.optionService = optionService;
    }

    //@GetMapping("/{categoryId}")
    //public String quizGet(@PathVariable Integer categoryId, Model model, HttpServletRequest request, HttpSession session) {
    @GetMapping("")
    public String quizGet(@RequestParam(required = false) Integer categoryId, Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Category category = categoryService.getCategoryById(categoryId);
            session.setAttribute("category", category);
            List<Question> tenQuestions = questionService.get10RandomQuestionsByCategoryId(categoryId);
            List<List<Option>> tenQuestionsOptions = new ArrayList<>();
            for (int i = 0; i < tenQuestions.size(); i++) {
                Integer questionId = tenQuestions.get(i).getId();
                List<Option> optionList = optionService.getOptionsByQuestionId(questionId);
                tenQuestionsOptions.add(optionList);
            }
            session.setAttribute("questionNumber", 0); // Start with 1
            session.setAttribute("tenQuestions", tenQuestions);
            session.setAttribute("tenQuestionsOptions", tenQuestionsOptions);
            Option selectedOption = new Option();
            model.addAttribute("selectedOption", selectedOption);
            // Data for database
            Timestamp startTime = new Timestamp(System.currentTimeMillis());
            String quizName = user.getUsername() + "-" + category.getName() + "-" + startTime;
            //System.out.println(quizName);
            //session.setAttribute("quizName", quizName);
            Quiz db_quiz = Quiz.builder().name(quizName).categoryId(categoryId).build();
            List<QuizQuestion> db_quizQuestionList = new ArrayList<>();
            for (int i = 0; i < tenQuestions.size(); i++) {
                Integer questionId = tenQuestions.get(i).getId();
                QuizQuestion quizQuestion = QuizQuestion.builder().questionId(questionId).build();
                db_quizQuestionList.add(quizQuestion);
            }
            Submission db_submission = Submission.builder().startTime(startTime).userId(user.getId()).build();
            session.setAttribute("db_quiz", db_quiz);
            session.setAttribute("db_quizQuestionList", db_quizQuestionList); // Need: quizId, selectedOptionId
            session.setAttribute("db_submission", db_submission); // Need: endTime, score, quizId
            return "quiz";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("")
    public String quizPost(@ModelAttribute("selectedOption") Option selectedOption, @RequestParam(required = false) String prev, @RequestParam(required = false) String next, @RequestParam(required = false) String submit, Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        Integer questionNumber = (Integer) session.getAttribute("questionNumber");
        List<QuizQuestion> db_quizQuestionList = (List<QuizQuestion>) session.getAttribute("db_quizQuestionList");
        db_quizQuestionList.get(questionNumber).setSelectedOptionId(selectedOption.getId());
        session.setAttribute("db_quizQuestionList", db_quizQuestionList);
        if (prev != null) {
            questionNumber--;
        } else if (next != null) {
            questionNumber++;
        }
        session.setAttribute("questionNumber", questionNumber);
        if (submit != null) {
            return "redirect:/result";
        } else {
            return "quiz";
        }
    }

}









