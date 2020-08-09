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
public abstract class AbstractDao<T> {

    /**
     * Constante para definir la transaccion create
     */
    private final String CREATE = "create";
    /**
     * Constante para definir la transaccion remove
     */

    private final String REMOVE = "remove";
    /**
     * Constante para definir la transaccion update
     */
    private final String UPDATE = "update";

    /**
     * objeto que establece la clase de la entidad
     */
    private Class<T> entityClass;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * metodo para agregar un campo
     *
     * @param entity de la base de datos
     * @throws Exception
     *
     */
    public void create(T entity) throws Exception {
        transaction(CREATE, entity);
    }

    /**
     * metodo para eliminar un campo
     *
     * @param id llave identificadora del campo
     * @throws Exception
     *
     */
    public void delete(T entity) throws Exception {
        transaction(REMOVE, entity);
    }

    /**
     * metodo para ejecutar UPDATE y actualiza un campo
     *
     * @param entity llave identificadora del campo y las actualizaciones del
     * registro
     * @throws Exception
     *
     */
    public void update(T entity) throws Exception {
        transaction(UPDATE, entity);
    }

    /**
     * metodo para realizar busqueda condicionado por ID
     *
     * @param id llave identificadora del campo
     * @throws Exception
     *
     */
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

    /**
     * Metodo FindAll() Metodo devuelve en una lista de la entidad
     *
     * @return List<T>
     */
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

    /**
     *
     * Metodo que ejecuta la transaccion deseada, recibiendo la entidad y el
     * nombre de la transaccion en un string
     *
     * @param method
     * @param entity
     * @throws Exception
     */
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
