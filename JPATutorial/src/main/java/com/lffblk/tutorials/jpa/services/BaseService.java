package com.lffblk.tutorials.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by lffblk on 14.05.2017.
 */
public abstract class BaseService {
    static BaseService instance;

    private final EntityManagerFactory emf;
    final EntityManager entityManager;

    BaseService() {
        emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        entityManager = emf.createEntityManager();
        clearTable();
    }

    public void destroy() {
        entityManager.close();
        emf.close();
        instance = null;
    }

    abstract void clearTable();
}
