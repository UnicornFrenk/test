package com.github.hib.dao;

import com.github.hib.dao.converters.ItemConverter;
import com.github.hib.dao.impl.DefaultItemDao;
import com.github.hib.entity.ItemEntity;
import com.github.hib.util.HibernateUtil;
import com.github.model.Item;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ItemDaoTest {

    @Test
    public void testSave() {
        ItemEntity testItem = new ItemEntity("pomme", "pomme",3,200);
        Assert.assertNotNull(testItem);
    }

    @Test
    public void saveItemSession() {
        Session session = HibernateUtil.getSession();
        ItemEntity order = new ItemEntity();
        order.setDescription("lala");
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        Assert.assertNotNull(order);
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
        Assert.assertNotNull(item);
        session.close();
    }

    @Test
    public void deleteSession() {
        ItemEntity testItem = new ItemEntity(1, "pomme", "pomme",3,200);
        System.out.println(testItem.toString());
        DefaultItemDao.getInstance().deleteItem(testItem.getName());

        Assert.assertNull(testItem);
    }

    @Test
    public void readItem(){
        final ItemEntity itemEntity = saveItem();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.get(ItemEntity.class, itemEntity.getId());
        session.getTransaction().commit();
        Assert.assertNotNull(itemEntity);
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
