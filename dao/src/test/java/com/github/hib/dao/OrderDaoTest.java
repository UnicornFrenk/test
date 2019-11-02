package com.github.hib.dao;

import com.github.hib.dao.converters.CategoryConverter;
import com.github.hib.dao.converters.OrderConverter;
import com.github.hib.dao.impl.DefaultOrderDao;
import com.github.hib.entity.Address;
import com.github.hib.entity.OrderEntity;
import com.github.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;


public class OrderDaoTest {

        @Test
        public void testSave() {
                OrderEntity testOrder = new OrderEntity(1,1, 200,new Address());
                OrderDao oDao = new DefaultOrderDao();
                oDao.createOrder(OrderConverter.fromEntity(testOrder));
        }

        @Test
        public void saveOrderSession() {
                Session session = HibernateUtil.getSession();
                OrderEntity order = new OrderEntity();
                order.setDeliveryAddress(new Address());
                session.beginTransaction();
                session.save(order);
                session.getTransaction().commit();
                session.close();

        }

        @Test
        public void updateSession() {
                final OrderEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                order.getTotalPrice();
                session.saveOrUpdate(order);
                session.getTransaction().commit();
                session.close();
        }

        @Test
        public void deleteSession() {
                OrderEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                order = session.get(OrderEntity.class, order.getId());
                session.delete(order);
                session.getTransaction().commit();
                session.close();
        }

        @Test
        public void read(){
                final OrderEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                session.get(OrderEntity.class, order.getId());
                session.getTransaction().commit();
                session.close();
        }

        private OrderEntity saveOrder(){
                Session session = HibernateUtil.getSession();
                OrderEntity order = new OrderEntity( 1,2,300,null);
                session.beginTransaction();
                session.save(order);
                session.getTransaction().commit();
                session.close();
                return order;
        }

}
