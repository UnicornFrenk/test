package com.github.impl;

import com.github.CategoryService;
import com.github.hib.dao.CategoryDao;
import com.github.hib.dao.impl.DefaultCategoryDao;
import com.github.model.Category;

import java.util.List;


public class DefaultCategoryService implements CategoryService {

    private CategoryDao categoryDao = DefaultCategoryDao.getInstance();

    private static class SingletonHolder {
        static final CategoryService HOLDER_INSTANCE = new DefaultCategoryService();
    }
    public static CategoryService getInstance() {

        return DefaultCategoryService
                .SingletonHolder
                .HOLDER_INSTANCE;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryDao
                .createCategory(category);
    }

    @Override
    public Category readCategory(String category_name) {
        return categoryDao
                .readCategory(category_name);
    }

    @Override
    public void updateCategory(String name, int id) {
        categoryDao
                .updateCategory(name,id);
    }

    @Override
    public void deleteCategory(String name) {
    }

    @Override
    public List<Category> getAll() {
       return categoryDao.getAll();
    }


    }
