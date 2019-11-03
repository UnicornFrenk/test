package com.github.hib.dao;

import com.github.hib.entity.ItemEntity;
import com.github.model.Item;

import java.util.List;

public interface ItemDao {
    Item createItem(Item item);

    Item readItem(String item_name);
    void updateItem(Integer price, String name);
    void deleteItem(String name);
    List<Item> getAll();


}
