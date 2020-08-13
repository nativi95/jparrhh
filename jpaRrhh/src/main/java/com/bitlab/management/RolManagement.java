/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.entities.Rol;
import com.bitlab.dao.RolDao;
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
public class RolManagement extends AbstractManagement<Rol> {

    private RolDao rolDao;
    private User user;

    public RolManagement() {
        super(Rol.class);
        rolDao = new RolDao();
    }

    @Override
    public RolDao getController() {
        return rolDao;
    }

    @Override
    public Rol getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Rol entity) {
        this.entity = entity;
    }

    @Override
    public List<Rol> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Rol> entities) {
        this.entities = entities;
    }

    @Override
    public void createEntity() {
        autoSet();
        entity.setRolRolNo(0);
        entity.setAdatecreate(new Date());
        entity.setAusercreate(user.getUsrUser());
        user = null;
        super.createEntity();
    }

    @Override
    public void updateEntity() {
        autoSet();
        user = null;
        super.updateEntity();
    }

    public void autoSet() {
        entity.setAdatechange(new Date());
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
    }

}
