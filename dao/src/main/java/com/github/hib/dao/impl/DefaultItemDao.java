package com.github.hib.dao.impl;

import com.github.hib.dao.ItemDao;
import com.github.hib.dao.converters.ItemConverter;
import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.entity.ItemEntity;
import com.github.hib.entity.PersonEntity;
import com.github.hib.util.EntityManagerUtil;
import com.github.hib.util.HibernateUtil;
import com.github.model.Item;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultItemDao  implements ItemDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultItemDao.class);

    private static class SingletonHolder {
        static final ItemDao HOLDER_INSTANCE = new DefaultItemDao();
    }

    public static ItemDao getInstance() {
        return DefaultItemDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public Item createItem(Item item) {
        ItemEntity iEntity = ItemConverter.toEntity(item);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(iEntity);
        session.getTransaction().commit();
        return ItemConverter.fromEntity(iEntity);
    }

    @Override
    public Item readItem(String item_name) {
        ItemEntity iEntity;
        try {
            iEntity = (ItemEntity) HibernateUtil
                    .getSession()
                    .createQuery("from ItemEntity i where i.name = :name")
                    .setParameter("name", item_name)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("item not found by name{}", item_name);
            iEntity = null;
        }
        return ItemConverter.fromEntity(iEntity);
    }


    @Override
    public void updateItem(Integer price, String name) {

        try {
            Session session = EntityManagerUtil.getSession();
            session.beginTransaction();
            session.createQuery("update ItemEntity i set i.price = :price where i.name = :name")
                    .setParameter("price", 30)
                    .setParameter("name",name)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (NoResultException e) {
            log.info("not found item{}", price);
        }
    }


    @Override
    public void deleteItem(String name) {

        try {
           HibernateUtil.getSession()
                    .createQuery("delete from ItemEntity i where i.name = :name")
                    .setParameter("name", name);
        } catch (NoResultException e) {
            log.info("item not found by name{}", name);
        }
    }

    @Override
    public List<Item> getAll() {
        final List<ItemEntity> authUser = HibernateUtil.getSession()
                .createQuery("from ItemEntity ")
                .list();
        return authUser.stream()
                .map(ItemConverter::fromEntity)
                .collect(Collectors.toList());
    }
}
