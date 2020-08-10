/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.PositionDao;
import com.bitlab.entities.Position;
import com.bitlab.entities.User;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

    @Override
    public void createEntity() {
        entity.setPosPositionNo(0);
        entity.setAdatechange(new Date());
        entity.setAdatecreate(new Date());
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAusercreate(user.getUsrUser());
        entity.setAuserchange(user.getUsrUser());
        super.createEntity();
    }
    
    @Override
    public void updateEntity() {
        entity.setAdatechange(new Date());
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
        super.updateEntity();
    }
    
}
