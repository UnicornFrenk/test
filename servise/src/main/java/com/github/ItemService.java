package com.github;

import Model.Item;

import java.util.List;

public interface ItemService {

    Item createItem(Item item);

    Item readItem(String item_name);

    int updateItem(String name, int category);
    int deleteItem(String name);
    List<Item> getAll();
}
