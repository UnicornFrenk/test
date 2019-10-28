package com.github.dao;

import com.github.model.Item;

import java.util.List;

public interface ItemDao {
    Item createItem(Item item);

    Item readItem(String item_name);

    int updateItem(String name, int category);
    int deleteItem(String name);
    List<Item> getAll();
}
