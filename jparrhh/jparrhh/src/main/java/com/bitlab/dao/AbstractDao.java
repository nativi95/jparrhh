/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author juana
 */
public abstract class AbstractDao<T>{
 
    private final String CREATE = "create";
  
    private final String REMOVE = "remove";
   
    private final String UPDATE = "update";

    private Class<T> entityClass;

  
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

  
    public void create(T entity) throws Exception {
        transaction(CREATE, entity);
    }

   
    public void delete(T entity) throws Exception {
        transaction(REMOVE, entity);
    }

    public void update(T entity) throws Exception {
        transaction(UPDATE, entity);
    }

    public T find(Object id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } catch (Exception e) {

            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }

   
    public List<T> findAll() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

   
    public void transaction(String method, T entity) throws Exception {
        EntityManager em = getEntityManager();
        try {

            em.getTransaction().begin();
            switch (method) {
                case CREATE:
                    em.persist(entity);
                    break;
                case UPDATE:
                    em.merge(entity);
                    break;
                case REMOVE:
                    em.remove(em.merge(entity));
                    break;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
    public abstract EntityManager getEntityManager();

}
