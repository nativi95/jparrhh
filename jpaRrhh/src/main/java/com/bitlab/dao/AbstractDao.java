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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author juana
 */
public abstract class AbstractDao<T> {
 private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);
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
        logger.debug("Se inicia Get Entity Manager");
        try {
            logger.debug("Retornando el objeto por ID");
            return em.find(entityClass, id);
        
        } catch (Exception e) {
        
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
                logger.debug("Conexion Cerrada");
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
        logger.debug("Se inicia Get Entity Manager");
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            logger.debug("Realizando consulta");
            Query q = em.createQuery(cq);
            logger.debug("Retornando resultado de la consulta");
            return q.getResultList();
            
        } catch (Exception e) {
            em.close();
            logger.debug("Retornando resultado de la consulta");
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
         logger.debug("Se inicia Get Entity Manager");
        try {

            em.getTransaction().begin();
            logger.debug("Se inicia la transaccion");
            switch (method) {
                case CREATE:
                    em.persist(entity);
                    logger.debug("Creando nueva entidad");
                    break;
                case UPDATE:
                    em.merge(entity);
                    logger.debug("Actualizando entidad");
                    break;
                case REMOVE:
                    em.remove(em.merge(entity));
                    logger.debug("Eliminando entidad");
                    break;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
                 logger.debug("Conexion Cerrada");
            }
        }
    }

    public abstract EntityManager getEntityManager();

}
