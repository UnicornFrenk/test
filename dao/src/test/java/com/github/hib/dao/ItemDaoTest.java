package com.github.hib.dao;

import com.github.hib.entity.Item;
import com.github.hib.util.EntityManagerUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class ItemDaoTest {

        @Before
        public void init() {
            EntityManager entityManager = EntityManagerUtil.getEntityManager("com.github.hib");
        }

        @Test
        public void testSave() {
            Item testItem = new Item("lemon", "sweet lemon", 500, 300);
            ItemDao iDao = new ItemDao();
            iDao.save(testItem);
        }

}
