package com.github.hib.dao;

import com.github.hib.dao.converters.CategoryConverter;
import com.github.hib.dao.impl.DefaultCategoryDao;
import com.github.hib.entity.CategoryEntity;
import com.github.hib.util.HibernateUtil;
import com.github.model.Category;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
public class CategoryDaoTest {


    @Test
    public void testSave() {

        CategoryEntity testCategory = new CategoryEntity("fruits");
        CategoryDao cDao = new DefaultCategoryDao();
        cDao.createCategory(CategoryConverter.fromEntity(testCategory));
    }

    @Test
    public void saveCategorySession() {
        Session session = HibernateUtil.getSession();
        CategoryEntity category = new CategoryEntity();
        category.setNameCategory("food");
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void updateSession() {
        final CategoryEntity category = saveCategory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        category.getNameCategory();
        session.saveOrUpdate(category);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void deleteSession() {
        CategoryEntity category = saveCategory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        category = session.get(CategoryEntity.class, category.getIdCategory());
        session.delete(category);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void read(){
        final CategoryEntity category = saveCategory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.get(CategoryEntity.class, category.getIdCategory());
        session.getTransaction().commit();
        session.close();
    }

    private CategoryEntity saveCategory(){
        Session session = HibernateUtil.getSession();
        CategoryEntity category = new CategoryEntity();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
        return category;
    }

}

