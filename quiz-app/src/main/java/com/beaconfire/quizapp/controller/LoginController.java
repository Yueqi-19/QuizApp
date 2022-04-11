package com.beaconfire.quizapp.controller;

import com.beaconfire.quizapp.dao.UserDao;
import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;
import com.beaconfire.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String loginGet(Model model, HttpServletRequest request) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        return "login";
    }

    @PostMapping("")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("errorMessage1", "Username and Password entered didn't match our records.");
            model.addAttribute("errorMessage2", "Please double-check and try again.");
            return "login";
        }
    }

}
