package com.github.hib.dao.impl;

import com.github.hib.dao.CategoryDao;
import com.github.hib.dao.ItemDao;
import com.github.hib.entity.CategoryEntity;
import com.github.hib.util.EntityManagerUtil;
import com.github.model.Category;
import com.github.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultCategoryDao implements CategoryDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultItemDao.class);

    private static class SingletonHolder {
        static final CategoryDao HOLDER_INSTANCE = new DefaultCategoryDao();
    }

    public static CategoryDao getInstance() {
        return DefaultCategoryDao.SingletonHolder.HOLDER_INSTANCE;
    }




    public int createCategory(Category category) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        return category.getIdCategory();
    }

    @Override
    public Item readCategory(String item_name) {
        return null;
    }

    @Override
    public int updateCategory(String name) {
        return 0;
    }

    @Override
    public int deleteCategory(String name) {
        return 0;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
