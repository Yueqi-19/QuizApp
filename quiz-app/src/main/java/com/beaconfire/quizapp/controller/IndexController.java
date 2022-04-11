package com.beaconfire.quizapp.controller;

import com.beaconfire.quizapp.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping(value = {"", "/", "/index", "/index.html", "/index.jsp"})
    public ModelAndView indexGet(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        //ModelAndView modelAndView = new ModelAndView("forward:/home");
        return modelAndView;
    }
}
