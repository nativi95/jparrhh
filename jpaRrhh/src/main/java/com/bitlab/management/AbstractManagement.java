/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.entities.Position;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author nativi
 * @param <T>
 */
public abstract class AbstractManagement<T> {

    private final String ERROR = "error";
    private final String INFO = "info";

    protected T entity;
    protected List<T> entities;
    private Class<T> entityClass;

    public AbstractManagement(Class<T> entityClass) {
        this.entityClass = entityClass;

    }

    public void newEntity() throws NoSuchMethodException {
        try {
            entity = entityClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo Postconstruct
     *
     */
    
    @PostConstruct
    public void init() {
        entities = getController().findAll();
        try {
            newEntity();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo Predestroyer
     *
     */
    @PreDestroy
    public void destroyed() {
        entities = null;
        entity = null;
    }

    public abstract AbstractDao<T> getController();

    public abstract T getEntity();

    public abstract void setEntity(T entity);

    public abstract List<T> getEntities();

    public abstract void setEntities(List<T> entities);

    /**
     * Metodo para crear una nueva entidad
     *
     * @param entity de la base de datos
     * @throws Exception
     * @throws NoSuchMethodException
     */
    public void createEntity() {
        try {
            System.out.println("La entidad de creacion era " + entity);
            getController().create(entity);
            message("Transacción exitosa", "Se agregó un nuevo elemento", INFO);
        } catch (Exception ex) {
            message("No se completó la transacción", "No fue creado por " + ex.getMessage(), ERROR);

            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                newEntity();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para Eliminar una Entidad
     *
     * @param entity de la base de datos
     * @throws Exception
     * @throws NoSuchMethodException
     */
    public void deteleEntity() {
        try {
            getController().delete(entity);
            message("Transacción exitosa", "Se eliminó el elemento seleccionado", INFO);
        } catch (Exception ex) {

            message("No se completó la transacción", "No fue eliminado por " + ex.getMessage(), ERROR);

            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                newEntity();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para Actualizar una Entidad
     *
     * @param entity de la base de datos
     * @throws Exception
     * @throws NoSuchMethodException
     */
    public void updateEntity() {
        try {
            getController().update(entity);
            message("Transacción exitosa", "Se actualizó el elemento seleccionado", INFO);

        } catch (Exception e) {
            message("No se completó la transacción", "No fue actualizado por " + e.getMessage(), ERROR);

            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                newEntity();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para Encontrar una Entidad
     *
     * @param int i
     * @throws Exception
     * @throws NoSuchMethodException
     */
    public void findEntity(int i) {
        try {
            entity = getController().find(i);
            System.out.println(entity);
        } catch (Exception ex) {
            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para Enviar Alertas al Usuario
     *
     * @param String head
     * @param String body
     * @param String type
     *
     */
    public void message(String head, String body, String type) {

        FacesMessage m = new FacesMessage();
        m.setSummary(head);
        m.setDetail(body);
        switch (type) {
            case ERROR:
                m.setSeverity(FacesMessage.SEVERITY_ERROR);
                break;
            case INFO:
                m.setSeverity(FacesMessage.SEVERITY_INFO);
                break;
            default:
                m.setSeverity(FacesMessage.SEVERITY_WARN);
                break;
        }
        FacesContext.getCurrentInstance().addMessage(null, m);
    }

    public void redirect(String page) {//permite redireccionar a la pagina extablecida
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/jpaRrhh/" + page + ".rh");
        } catch (IOException ex) {
            Logger.getLogger(AbstractManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
