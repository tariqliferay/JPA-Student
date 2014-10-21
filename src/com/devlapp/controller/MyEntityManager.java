package com.devlapp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManager {
    //to add data to student table
    public boolean add(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
}
