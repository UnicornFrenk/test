package com.github.hib.dao.converters;

import com.github.hib.entity.BookingEntity;
import com.github.model.Order;

public class BookingConverter {
    public static BookingEntity toEntity(Order order) {
        if (order == null) {
            return null;
        }
        final BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setId(order.getId());
        bookingEntity.setUser_Id(order.getUser_Id());
        bookingEntity.setItem_id(order.getItem_id());
        bookingEntity.setTotalPrice(order.getTotalPrice());
        bookingEntity.setDeliveryAddress(order.getDeliveryAddress());
        return bookingEntity;
    }

    public static Order fromEntity(BookingEntity bookingEntity) {
        if (bookingEntity == null) {
            return null;
        }
        return new Order(bookingEntity.getId(), bookingEntity.getUser_Id(), bookingEntity.getItem_id(), bookingEntity.getTotalPrice(), bookingEntity.getDeliveryAddress());

    }
}
