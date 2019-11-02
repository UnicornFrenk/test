package com.github.hib.dao;

import com.github.model.Category;
import com.github.model.Item;

import java.util.List;

public interface CategoryDao {
    int createCategory(Category category);

    Item readCategory(String item_name);

    int updateCategory(String name);
    int deleteCategory(String name);
    List<Category> getAll();


}
