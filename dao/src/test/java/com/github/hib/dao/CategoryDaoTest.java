package com.github.hib.dao;

import com.github.hib.dao.impl.DefaultCategoryDao;
import com.github.hib.entity.CategoryEntity;
import com.github.hib.util.EntityManagerUtil;
import com.github.model.Category;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CategoryDaoTest {


    private CategoryEntity saveCategory() {
        Session session = EntityManagerUtil.getEntityManager();
        CategoryEntity category = new CategoryEntity("kiwi");
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();

        return category;
    }

    @Test
    public void createTest() {
        Category testCategory = DefaultCategoryDao.getInstance().createCategory(new Category(null, "look"));
        System.out.println(testCategory);

        Assertions.assertNotNull(testCategory);
    }

    @Test
    public void read() {
        final CategoryEntity category = saveCategory();
        DefaultCategoryDao.getInstance().readCategory(category.getNameCategory());
        System.out.println(category);

        Assertions.assertNotNull(category.getNameCategory());
    }

    @Test
    public void updateCategory() {
        final CategoryEntity category = saveCategory();
        DefaultCategoryDao.getInstance().updateCategory("kiwi", category.getIdCategory());

        Assertions.assertEquals(category.getNameCategory(), "kiwi");
    }

    @Test
    public void deleteSession() {
        CategoryEntity category = saveCategory();
        DefaultCategoryDao.getInstance().deleteCategory(category.getNameCategory());

        Assertions.assertNull(category);
    }

    @Test
    public void getAll() {
        final CategoryEntity category = saveCategory();
        List<Category> list = DefaultCategoryDao.getInstance().getAll();
        System.out.println(list);

        Assertions.assertNotNull(list);
    }


}

