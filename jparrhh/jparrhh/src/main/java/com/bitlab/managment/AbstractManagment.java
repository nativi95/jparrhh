/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managment;

import com.bitlab.dao.AbstractDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author juana
 */

public abstract class AbstractManagment<T> {
    
    private T entitySelected;
    private List<T> entities;
    private Class<T> EntityClass;

    public AbstractManagment(Class<T> entity) {
        EntityClass = entity;
    }
    
    @PostConstruct
//    public void init(){
//    entities= getController().findAll();
//    }
    
    @PreDestroy
    public void destroit(){
    entitySelected = null;
    entities = null;
    EntityClass = null;
    }
    
    public abstract AbstractDao<T> getController();

    public T getEntitySelected() {
        return entitySelected;
    }

    public void setEntitySelected(T entitySelected) {
        this.entitySelected = entitySelected;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
    
    
}
