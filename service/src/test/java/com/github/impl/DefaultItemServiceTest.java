package com.github.impl;

import com.github.hib.dao.ItemDao;
import com.github.hib.entity.*;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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


    @BeforeAll
    static public void initialization() {

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(new ItemEntity("apple", "apple", 5, 5));
        em.persist(new ItemEntity("nuts", "nuts", 5, 5));
        em.persist(new ItemEntity("apple1", "apple", 52, 5));
        em.persist(new ItemEntity("apple2", "apple", 52, 5));
        em.persist(new ItemEntity("apple3", "apple", 5, 5));
        em.persist(new ItemEntity("apple4", "apple", 5, 5));
        em.persist(new ItemEntity("apple5", "apple", 5, 5));

        em.getTransaction().commit();
        em.clear();
        em.close();
    }

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

        when(dao.readItem("apple")).thenReturn(new Item("apple", "apple", 300, 20));

        Item itemFromDb = dao.readItem("apple");
        Integer expPrice = 20;
        assertNotNull(itemFromDb);
        assertEquals(expPrice, itemFromDb.getPriceForOne());

    }


    @Test
    public void createItemTest() {
        Item item = new Item("nuts", "nuts", 1000, 500);
        dao.createItem(item);
        String real = item.getItemName();
        String exp = "nuts";
        assertEquals(exp, real);

//        Item item1 = new Item("nuts", "nuts", 1000, 500);
//        Item item2 = new Item("nuts", "nuts", 1000, 500);;
//        when(dao.createItem(item1)).thenReturn(item2);
//
//        Item itemFromDb = service.readItem("nuts");
//
//        assertEquals(item2.getItemName(),itemFromDb.getItemName());
    }


    @Test
    public void readItemTest() {

        when(dao.readItem("apple")).thenReturn(new Item("apple", "apple", 300, 20));

        Item itemFromDb = dao.readItem("apple");
        String expName = "apple";
        // assertNotNull(itemFromDb);
        assertEquals(expName, itemFromDb.getItemName());
    }

    @Test
    public void updateItemTest() {   //todo

        doNothing().when(dao).updateItem(anyInt(), anyString());
        service.updateItem(1, "apple");

        verify(dao).updateItem(1, "apple");}

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