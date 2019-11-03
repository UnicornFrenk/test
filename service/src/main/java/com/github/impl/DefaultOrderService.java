package com.github.impl;

import com.github.OrderService;
import com.github.hib.dao.OrderDao;
import com.github.hib.dao.impl.DefaultOrderDao;
import com.github.hib.entity.Address;
import com.github.model.Order;

import java.util.List;

public class DefaultOrderService implements OrderService {

    private OrderDao orderDao = DefaultOrderDao.getInstance();

    private static class SingletonHolder {
        static final OrderService HOLDER_INSTANCE = new DefaultOrderService();
    }

    public static OrderService getInstance() {

        return DefaultOrderService
                .SingletonHolder
                .HOLDER_INSTANCE;
    }

    @Override
    public Integer createOrder(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    public Order readOrder(int id) {
        return orderDao.readOrder(id);
    }

    @Override
    public Order getOrderByPersonLogin(String login) {
        return orderDao.getOrderByPersonLogin(login);
    }

    @Override
    public void updateOrder(int id, Address address) {
        orderDao.updateOrder(id,address);
    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
