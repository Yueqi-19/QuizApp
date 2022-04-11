package com.beaconfire.quizapp.dao;

import com.beaconfire.quizapp.domain.Category;
import com.beaconfire.quizapp.domain.User;

import java.util.List;
import java.util.Set;

public interface CategoryDao {

    Category getCategoryById(Integer id);

    List<Category> getAllCategories();

}
