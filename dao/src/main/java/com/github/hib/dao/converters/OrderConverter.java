package com.github.hib.dao.converters;

import com.github.hib.entity.CategoryEntity;
import com.github.hib.entity.ItemEntity;
import com.github.hib.entity.OrderEntity;
import com.github.model.Item;
import com.github.model.Order;

public class OrderConverter {
    public static OrderEntity toEntity(Order order) {
        if (order == null) {
            return null;
        }
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setUser_Id(order.getUser_Id());
        orderEntity.setItem_id(order.getItem_id());
        orderEntity.setTotalPrice(order.getTotalPrice());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        return orderEntity;
    }

    public static Order fromEntity(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return new Order(orderEntity.getId(), orderEntity.getUser_Id(),orderEntity.getItem_id(),orderEntity.getTotalPrice(),orderEntity.getDeliveryAddress());

    }
}
