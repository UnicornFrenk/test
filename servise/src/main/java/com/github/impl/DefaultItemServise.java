package com.github.impl;

import DAO.ItemDao;
import DAO.impl.DefaultItemDao;
import Model.Item;
import com.github.ItemService;

import java.util.List;

public class DefaultItemServise implements ItemService {
    private ItemDao itemDao = DefaultItemDao.getInstance();

    private static volatile ItemService instance;

    public static ItemService getInstance() {
        ItemService localInstance = instance;
        if (localInstance == null) {
            synchronized (ItemService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultItemServise();
                }
            }
        }
        return localInstance;
    }


    @Override
    public Item createItem(Item item) {
        return itemDao.createItem(item);
    }

    @Override
    public Item readItem(String item_name) {

        return itemDao.readItem(item_name);
    }

    @Override
    public int updateItem(String name, int category) {
        return itemDao.updateItem(name, category);
    }

    @Override
    public int deleteItem(String name) {
        return itemDao.deleteItem(name);

    }

    @Override
    public List<Item> getAll() {
        return null;
    }
}
