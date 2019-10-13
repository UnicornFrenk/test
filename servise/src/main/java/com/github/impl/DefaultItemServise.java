package com.github.impl;

import Dao.ItemDao;
import Dao.impl.DefaultItemDao;
import Model.Item;
import com.github.ItemService;

import java.util.List;

public class DefaultItemServise implements ItemService {
    private static class SingletonHolder {
        static final ItemService HOLDER_INSTANCE = new DefaultItemServise();
    }

    public static ItemService getInstance() {
        return DefaultItemServise.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public Item createItem(Item item) {
        return DefaultItemDao.getInstance().createItem(item);
    }

    @Override
    public Item readItem(String item_name) {

        return DefaultItemDao.getInstance().readItem(item_name);
    }

    @Override
    public int updateItem(String name, int category) {
        return DefaultItemDao.getInstance().updateItem(name, category);
    }

    @Override
    public int deleteItem(String name) {
        return DefaultItemDao.getInstance().deleteItem(name);

    }

    @Override
    public List<Item> getAll() {
        return DefaultItemDao.getInstance().getAll();
    }
}
