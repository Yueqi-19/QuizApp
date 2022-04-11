package com.beaconfire.quizapp.controller;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;
import com.beaconfire.quizapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String homeGet(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Category> categoryList = categoryService.getAllCategories();
            model.addAttribute("categoryList", categoryList);
            return "home";
        } else {
            return "redirect:/login";
        }
    }

}
