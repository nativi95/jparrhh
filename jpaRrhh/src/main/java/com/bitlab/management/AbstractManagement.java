/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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

    /**
     * constante para especificar error
     */
    protected static final String ERROR = "error";

    /**
     * constante para especificar info
     */
    protected static final String INFO = "info";

    /**
     * constante para especificar advertencia
     */
    protected static final String WARN = "warn";

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
     */
    public void createEntity() {
        try {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@LA ENTITY "+entity);
            getController().create(entity);
            message("Transacción exitosa", "Se agregó un nuevo elemento", INFO);
        } catch (Exception ex) {
            message("No se completó la transacción", "No fue creado por " + ex.getMessage(), ERROR);

        } finally {
            init();
        }
    }

    /**
     * Metodo que permite eliminar una entidad
     */
    public void deleteEntity() {
        try {
            getController().delete(entity);
            message("Transacción exitosa", "Se eliminó el elemento seleccionado", INFO);

        } catch (Exception e) {
            message("No se completó la transacción", "No fue elimina por " + e.getMessage(), ERROR);

        } finally {
            init();
        }
    }

    /**
     * Metodo para Actualizar una Entidad
     *
     */
    public void updateEntity() {
        try {
            getController().update(entity);
            message("Transacción exitosa", "Se actualizó el elemento seleccionado", INFO);

        } catch (Exception e) {
            message("No se completó la transacción", "No fue actualizado por " + e.getMessage(), ERROR);

        } finally {
            init();
        }
    }

    /**
     * Metodo para Encontrar una Entidad
     *
     * @param i
     */
    public void findEntity(int i) {
        try {
            entity = getController().find(i);
            System.out.println(entity);
        } catch (Exception ex) {

        }
    }

    /**
     * Metodo para Enviar Alertas al Usuario
     *
     * @param head
     * @param body
     * @param type
     *
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
            case WARN:
                m.setSeverity(FacesMessage.SEVERITY_WARN);
                break;
        }
        FacesContext.getCurrentInstance().addMessage(null, m);
    }

    public void redirect(String page) {//permite redireccionar a la pagina extablecida
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/" + page + ".rh");
        } catch (IOException ex) {

        }
    }

}
