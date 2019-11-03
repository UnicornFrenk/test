package com.github.impl;

import com.github.ItemService;
import com.github.hib.dao.ItemDao;
import com.github.hib.dao.impl.DefaultItemDao;
import com.github.model.Item;

import java.util.List;

public class DefaultItemService implements ItemService {

    private ItemDao itemDao = DefaultItemDao.getInstance();

    private static class SingletonHolder {
        static final ItemService HOLDER_INSTANCE = new DefaultItemService();
    }

    public static ItemService getInstance() {

        return DefaultItemService
                .SingletonHolder
                .HOLDER_INSTANCE;
    }


    @Override
    public Item createItem(Item item) {
        return itemDao
                .createItem(item);
    }

    @Override
    public Item readItem(String item_name) {

        return itemDao
                .readItem(item_name);
    }

    @Override
    public void updateItem(Integer price, String  name) {
        itemDao.updateItem(price,name);
    }

    @Override
    public void deleteItem(String name) {

    }

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }
}
