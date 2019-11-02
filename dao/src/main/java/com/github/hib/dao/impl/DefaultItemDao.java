package com.github.hib.dao.impl;

import com.github.hib.dao.ItemDao;
import com.github.hib.dao.converters.ItemConverter;
import com.github.hib.entity.ItemEntity;
import com.github.hib.util.HibernateUtil;
import com.github.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public Item createItem(ItemEntity item) {
        return null;
    }

    @Override
    public Item readItem(String item_name) {
        return null;
    }

    @Override
    public int updateItem(String name, int category) {
        return 0;
    }

    @Override
    public int deleteItem(String name) {
        return 0;
    }

    @Override
    public List<Item> getAll() {
        final List<ItemEntity> authUser = HibernateUtil.getSession().createQuery("from ItemEntity ")
                .list();
        return authUser.stream()
                .map(ItemConverter::fromEntity)
                .collect(Collectors.toList());
    }
}
