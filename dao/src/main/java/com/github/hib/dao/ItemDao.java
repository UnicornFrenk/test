package com.github.hib.dao;

import com.github.hib.entity.ItemEntity;
import com.github.model.Item;

import java.util.List;

public interface ItemDao {
    Item createItem(ItemEntity item);

    Item readItem(String item_name);

    int updateItem(String name, int category);
    int deleteItem(String name);
    List<Item> getAll();


}
