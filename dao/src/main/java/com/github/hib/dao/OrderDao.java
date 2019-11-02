package com.github.hib.dao;

import com.github.model.Order;

import java.util.List;

public interface OrderDao {

    Order createOrder(Order order);

    Order readOrder(int id);

    Order updateOrder(int id);
    int deleteOrder(int id);
    List<Order> getAll();
}
