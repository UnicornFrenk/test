package com.github.impl;

import com.github.hib.dao.OrderDao;
import com.github.hib.entity.Address;
import com.github.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DefaultOrderServiceTest {

    @Mock
    OrderDao dao;
    @InjectMocks
    DefaultOrderService service;

    @Test
    public void getInstance() {
        DefaultOrderService.getInstance();
    }

    @Test
    public void testOrderNotExist() {

        when(dao.readOrder(1)).thenReturn(null);
        Order order = dao.readOrder(1);
        assertNull(order);
    }

    @Test
    public void readOrderTest() {
        Order order = new Order(1, null, null, null, null);
        when(dao.readOrder(1)).thenReturn(order);

        Integer orderFromDb = dao.readOrder(1).getId();
        Integer expName = 1;
        // assertNotNull(orderFromDb);
        assertEquals(expName, orderFromDb);
    }

    @Test
    public void updateOrderTest() {   //todo

        doNothing().when(dao).updateOrder(anyInt(), any());
        service.updateOrder(1, new Address());

        verify(dao).updateOrder(1, new Address());
    }


    @Test
    public void deleteOrderTest() {    //todo

        when(dao.readOrder(1)).thenReturn(null);

        dao.deleteOrder(1);

        Order id = dao.readOrder(1);

        assertNull(id);
    }

    @Test
    public void getAllOrdersTest() {
        when(dao.getAll()).thenReturn(new ArrayList<Order>());
        List<Order> orders = service.getAll();

        assertNotNull(orders);
    }


}
