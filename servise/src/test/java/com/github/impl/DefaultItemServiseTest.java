package com.github.impl;

import Model.Item;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DefaultItemServiseTest extends Mockito {

    @Test
    public void getInstance() {
        DefaultItemServise.getInstance();
    }

    @Test
    public void createItem() {
        Item item = new Item("nuts","nuts",1000,3,500);
        DefaultItemServise.getInstance().createItem(item);
    }

    @Test
    public void readItem() {
        DefaultItemServise.getInstance().readItem("nuts");
    }

    @Test
    public void updateItem() {
        DefaultItemServise.getInstance().updateItem("nuts",6);
    }

    @Test
    public void deleteItem() {
        DefaultItemServise.getInstance().deleteItem("nuts");
    }

    @Test
    public void getAll() {
        DefaultItemServise.getInstance().getAll();
    }
}