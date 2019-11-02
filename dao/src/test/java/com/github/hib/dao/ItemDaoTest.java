package com.github.hib.dao;

import com.github.hib.dao.impl.DefaultItemDao;
import com.github.hib.entity.ItemEntity;
import com.github.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;


public class ItemDaoTest {

    @Test
    public void testSave() {
        ItemEntity testItem = new ItemEntity("pomme", "pomme",3,200);
        ItemDao iDao = new DefaultItemDao();
        iDao.createItem(testItem);
    }

    @Test
    public void saveItemSession() {
        Session session = HibernateUtil.getSession();
        ItemEntity order = new ItemEntity();
        order.setDescription("lala");
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void updateSession() {
        final ItemEntity item = saveItem();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        item.getDescription();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void deleteSession() {
        ItemEntity order = saveItem();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        order = session.get(ItemEntity.class, order.getId());
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void read(){
        final ItemEntity order = saveItem();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.get(ItemEntity.class, order.getId());
        session.getTransaction().commit();
        session.close();
    }

    private ItemEntity saveItem(){
        Session session = HibernateUtil.getSession();
        ItemEntity item = new ItemEntity();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

}
