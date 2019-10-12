package DAO.impl;

import Model.AuthUser;
import Model.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultItemDaoTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void createItem() {
        Item item = new Item("grape","sweet grape", 200,2,400);
        DefaultItemDao.getInstance().createItem(item);
    }

    @Test
    public void readItem() {
        DefaultItemDao.getInstance().readItem("tomato");

    }

    @Test
    public void updateItem() {

        DefaultItemDao.getInstance().updateItem("grape",3);
    }

    @Test
    public void deleteItem() {
DefaultItemDao.getInstance().deleteItem("grape");
    }

    @Test
    public void getAll() {
        DefaultItemDao.getInstance().getAll();
        System.out.println(Item.class.toString());
    }
}