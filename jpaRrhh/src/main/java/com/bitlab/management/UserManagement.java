/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.Utils.Sha;
import com.bitlab.dao.RolDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.Rol;
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
public class UserManagement extends AbstractManagement<User> {

    private UserDao userDao;
    private RolDao rolDao;
    private Rol rol;
    private User user;

    public UserManagement() {
        super(User.class);
        userDao = new UserDao();
        rolDao = new RolDao();
        rol = new Rol();
    }

    @Override
    public UserDao getController() {
        return userDao;
    }

    @Override
    public User getEntity() {
        return entity;
    }

    @Override
    public void setEntity(User entity) {
        this.entity = entity;
    }

    @Override
    public List<User> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<User> entities) {
        this.entities = entities;
    }

    public List<Rol> getRoles() {
        return rolDao.findAll();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public void createEntity() {
        entity.setUsrUserNo(0);
        autoSet();
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
        entity.setUsrRolNo(rol);
        rol = new Rol();
        entity.setUserPassword(Sha.encrypt(entity.getUserPassword()));
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
    }

}
