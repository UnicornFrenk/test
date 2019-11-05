package com.github.hib.dao;

import com.github.hib.dao.converters.BookingConverter;
import com.github.hib.dao.impl.DefaultOrderDao;
import com.github.hib.entity.Address;
import com.github.hib.entity.BookingEntity;
import com.github.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;


public class OrderDaoTest {

        @Test
        public void testSave() {
                BookingEntity testOrder = new BookingEntity(1,1, 200,new Address());
                OrderDao oDao = new DefaultOrderDao();
                oDao.createOrder(BookingConverter.fromEntity(testOrder));
        }

        @Test
        public void saveOrderSession() {
                Session session = HibernateUtil.getSession();
                BookingEntity order = new BookingEntity();
                order.setDeliveryAddress(new Address());
                session.beginTransaction();
                session.save(order);
                session.getTransaction().commit();
                session.close();

        }

        @Test
        public void updateSession() {
                final BookingEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                order.getTotalPrice();
                session.saveOrUpdate(order);
                session.getTransaction().commit();
                session.close();
        }

        @Test
        public void deleteSession() {
                BookingEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                order = session.get(BookingEntity.class, order.getId());
                session.delete(order);
                session.getTransaction().commit();
                session.close();
        }

        @Test
        public void read(){
                final BookingEntity order = saveOrder();
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                session.get(BookingEntity.class, order.getId());
                session.getTransaction().commit();
                session.close();
        }

        private BookingEntity saveOrder(){
                Session session = HibernateUtil.getSession();
                BookingEntity order = new BookingEntity( 1,2,300,null);
                session.beginTransaction();
                session.save(order);
                session.getTransaction().commit();
                session.close();
                return order;
        }

}
