package com.github;

import com.github.hib.entity.Address;
import com.github.model.Order;

import java.util.List;

public interface OrderService {

    Integer createOrder(Order order);

    Order readOrder(int id);
    Order getOrderByPersonLogin(String login);

    void updateOrder(int id, Address address);
    void deleteOrder(int id);
    List<Order> getAll();
}
