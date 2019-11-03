package com.github.hib.dao.impl;

import com.github.hib.dao.CategoryDao;
import com.github.hib.dao.converters.CategoryConverter;
import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.entity.CategoryEntity;
import com.github.hib.entity.PersonEntity;
import com.github.hib.util.EntityManagerUtil;
import com.github.hib.util.HibernateUtil;
import com.github.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCategoryDao implements CategoryDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultItemDao.class);

    private static class SingletonHolder {
        static final CategoryDao HOLDER_INSTANCE = new DefaultCategoryDao();
    }

    public static CategoryDao getInstance() {
        return DefaultCategoryDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Category createCategory(Category category) {
       return null;
    }

    @Override
    public Category readCategory(String category_name) {
        CategoryEntity cEntity;
        try {
            cEntity = (CategoryEntity) HibernateUtil.getSession().createQuery("from CategoryEntity c where c.nameCategory = :name").setParameter("name", category_name).getSingleResult();
        } catch (NoResultException e) {
            log.info("category not found by category_name{}", category_name);
            cEntity = null;
        }
        return CategoryConverter.fromEntity(cEntity);
    }

    @Override
    public void updateCategory(String name, int id) {
        try {
        HibernateUtil
                    .getSession()
                    .createQuery("update CategoryEntity c set c.nameCategory = :name where c.id = :id")
                    .setParameter("id", id)
                    .setParameter("name",name)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("category not found by id{}", id);
        }
    }

    @Override
    public void deleteCategory(String name) {
        CategoryEntity cEntity;
        try {
            cEntity = (CategoryEntity) HibernateUtil
                    .getSession()
                    .createQuery("delete from CategoryEntity c where c.nameCategory = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("category not found by name{}", name);
            cEntity = null;
        }
    }

    @Override
    public List<Category> getAll() {
        final List<CategoryEntity> categoryList = HibernateUtil
                .getSession()
                .createQuery("from CategoryEntity ")
                .list();
        return categoryList
                .stream()
                .map(CategoryConverter::fromEntity)
                .collect(Collectors.toList());
    }
    }

