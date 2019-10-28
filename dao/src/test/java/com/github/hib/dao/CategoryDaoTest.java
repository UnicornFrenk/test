package com.github.hib.dao;

import com.github.hib.entity.Category;
import com.github.hib.util.EntityManagerUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class CategoryDaoTest {

    @Before
    public void init() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager("com.github.hib");
    }

    @Test
    public void testSave() {
        Category testCategory = new Category("fruits");
        CategoryDao cDao = new CategoryDao();
        cDao.save(testCategory);
    }

}

