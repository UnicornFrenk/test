package com.github.dao;

import com.github.dao.impl.DefaultItemDao;
import com.github.model.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DefaultItemDaoTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void createItem() {
        Item item = new Item("grape", "sweet grape", 200, 2, 400);
        DefaultItemDao.getInstance().createItem(item);
        String name = item.getItemName();
        String exp = "grape";
        assertEquals( exp, name);
    }

    @Test
    public void readItem() {
        Item item = DefaultItemDao.getInstance().readItem("tomato");
        int catedory = item.getItemCategoryId();
        int categoryexp = item.getItemCategoryId();
        assertEquals( categoryexp, catedory);
        // System.out.println(categoryexp+""+catedory);


    }

    @Test
    public void updateItem() {
        DefaultItemDao.getInstance().updateItem("tomato", 3);
        Item item = DefaultItemDao.getInstance().readItem("tomato");
        int category = item.getItemCategoryId();
        int exp = 3;
        assertEquals(exp, category);
        System.out.println(exp + category);


    }

    @Test
    public void deleteItem() {
        DefaultItemDao.getInstance().deleteItem("grape");
        Item item = DefaultItemDao.getInstance().readItem("grape");
        assertNull(item);
    }

    @Test
    public void getAll() {
        List<Item> expected = DefaultItemDao.getInstance().getAll();
        assertNotNull(expected);
    }
}