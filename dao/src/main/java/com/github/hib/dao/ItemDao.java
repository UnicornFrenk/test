package com.github.hib.dao;

import com.github.hib.entity.ItemEntity;
import com.github.model.Category;
import com.github.model.Item;

import java.util.List;

public interface ItemDao {
    Item createItem(Item item);

    Item readItem(String item_name);
    Item readItem(Integer id);

    void updateItem(Integer price, String name);
    void updateItem(Integer price, Integer id);

    void deleteItem(Integer id);
    List<Item> getAll();

    List<Item> getPage(int page);


    long getCountOfItems();
}
