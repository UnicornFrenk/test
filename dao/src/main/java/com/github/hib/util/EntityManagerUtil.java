package com.github.hib.util;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emFactory = null;

    public static EntityManager getEntityManager() {
        return getEntityManager("com.github.hib");
    }

    public static EntityManager getEntityManager(String unit) {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory(unit);
        }
        return emFactory.createEntityManager();
    }

    public static void closeEMFactory() {
        emFactory.close();
    }

    public static Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }
}
