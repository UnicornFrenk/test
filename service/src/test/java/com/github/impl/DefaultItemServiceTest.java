package com.github.impl;

import com.github.hib.dao.ItemDao;
import com.github.hib.dao.impl.DefaultItemDao;
import com.github.hib.entity.ItemEntity;
import com.github.hib.util.EntityManagerUtil;
import com.github.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DefaultItemServiceTest {

    @Mock
    ItemDao dao;
    @InjectMocks
    DefaultItemService service;


    @Test
    public void getInstance() {
        DefaultItemService.getInstance();
    }

    @Test
    public void testItemNotExist() {

        when(dao.readItem("nuts")).thenReturn(null);

        Item item = dao.readItem("nuts");

        assertNull(item);
    }


    @Test
    public void testPriceCorrect() {    //todo

        when(dao.readItem("apple")).thenReturn(new Item());

        Item itemFromDb = dao.readItem("apple");
        assertNotNull(itemFromDb);

    }


    @Test
    public void createItemTest() {
        Item item = new Item("nuts", "nuts", 1000, 500);
        when(dao.createItem(item)).thenReturn(item);

        Item itemFromDb = service.createItem(item);

        assertNotNull(itemFromDb);
        assertEquals(item.getItemName(), itemFromDb.getItemName());
    }


    @Test
    public void readItemTest() {
        when(dao.readItem("apple")).thenReturn(new Item("apple", null, null, null));

        Item itemFromDb = service.readItem("apple");

        assertNotNull(itemFromDb);
        assertEquals("apple", itemFromDb.getItemName());
    }

    @Test
    public void updateItemTest() {   //todo

        doNothing().when(dao).updateItem(anyInt(), anyString());
        service.updateItem(1, "apple");

        verify(dao).updateItem(1, "apple");
    }

    @Test
    public void deleteItemTest() {

        when(dao.readItem("nuts")).thenReturn(new Item());

        dao.deleteItem("apple");

        assertNull(dao.readItem("apple"));
    }

    @Test
    public void getAllItemsTest() {
        when(dao.getAll()).thenReturn(new ArrayList<Item>());
        List<Item> items = service.getAll();
        assertNotNull(items);
    }

}