/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.PositionDao;
import com.bitlab.entities.Position;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class PositionManagement extends AbstractManagement<Position> {

    private PositionDao positionDao;

    public PositionManagement() {
        super(Position.class);
        positionDao = new PositionDao();
    }


    @Override
    public PositionDao getController() {
        return positionDao;
    }

    @Override
    public Position getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Position entity) {
        this.entity = entity;
    }

    @Override
    public List<Position> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Position> entities) {
       this.entities = entities;
    }

}
