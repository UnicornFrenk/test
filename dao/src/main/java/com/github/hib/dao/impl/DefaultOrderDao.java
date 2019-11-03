package com.github.hib.dao.impl;

import com.github.hib.dao.CategoryDao;
import com.github.hib.dao.OrderDao;
import com.github.hib.dao.converters.OrderConverter;
import com.github.hib.dao.converters.PersonConverter;
import com.github.hib.entity.Address;
import com.github.hib.entity.OrderEntity;
import com.github.hib.entity.PersonEntity;
import com.github.hib.util.HibernateUtil;
import com.github.model.Order;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultOrderDao implements OrderDao {


    private static final Logger log = LoggerFactory.getLogger(DefaultItemDao.class);

    private static class SingletonHolder {
        static final OrderDao HOLDER_INSTANCE = new DefaultOrderDao();
    }

    public static OrderDao getInstance() {
        return DefaultOrderDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public Integer createOrder(Order order) {
        OrderEntity oEntity = OrderConverter.toEntity(order);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(oEntity);
        session.getTransaction().commit();
        return oEntity.getId();
    }

    @Override
    public Order readOrder(int id) {
        OrderEntity oEntity;
        try {
            oEntity = (OrderEntity) HibernateUtil
                    .getSession()
                    .createQuery("from OrderEntity o where o.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("order not found by id{}", id);
            oEntity = null;
        }
        return OrderConverter.fromEntity(oEntity);
    }

    @Override
    public Order getOrderByPersonLogin(String login) {
        OrderEntity oEntity;
        try {
            oEntity = (OrderEntity) HibernateUtil
                    .getSession()
                    .createQuery("from OrderEntity o join PersonEntity p on p.id=o.user_Id where p.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("person not found by login{}", login);
            oEntity = null;
        }
        return OrderConverter.fromEntity(oEntity);
    }

    @Override
    public void updateOrder(int id, Address address) {
        try {
         HibernateUtil
                    .getSession()
                    .createQuery("update OrderEntity o set o.deliveryAddress = :address where o.user_Id = :id")
                    .setParameter("id", id)
                    .setParameter("address", address)
                    .executeUpdate();
        } catch (NoResultException e) {
            log.info("user not found by login{}", id);
        }
    }

    @Override
    public void deleteOrder(int id) {
        try {
             HibernateUtil
                    .getSession()
                    .createQuery("delete from OrderEntity o where o.id = :id")
                    .setParameter("id", id).executeUpdate();
        } catch (NoResultException e) {
            log.info("order not found by id{}", id);
        }
    }

    @Override
    public List<Order> getAll() {
        final List<OrderEntity> orders = HibernateUtil
                .getSession()
                .createQuery("from OrderEntity ")
                .list();
        return orders.stream()
                .map(OrderConverter::fromEntity)
                .collect(Collectors.toList());
    }
}
