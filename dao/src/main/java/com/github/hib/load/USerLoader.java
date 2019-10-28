//package com.github.hib.load;
//
//import com.github.hib.pojo.User;
//import com.github.hib.util.HibernateUtil;
//
//import javax.persistence.EntityManager;
//
//public class USerLoader {
//    public static void main (String []args) throws Exception{
//        User user = new User("Sara", "Sara", "user");
//        EntityManager em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
//        HibernateUtil.close();
//    }
//}
