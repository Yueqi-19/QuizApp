package com.beaconfire.quizapp.service.impl;

import com.beaconfire.quizapp.dao.CategoryDao;
import com.beaconfire.quizapp.dao.UserDao;
import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;
import com.beaconfire.quizapp.service.CategoryService;
import com.beaconfire.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = categoryDao.getCategoryById(id);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryDao.getAllCategories();
        return categoryList;
    }

}
