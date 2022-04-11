package com.beaconfire.quizapp.service;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Category getCategoryById(Integer id);

    List<Category> getAllCategories();

}
