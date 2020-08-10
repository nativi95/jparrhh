/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.RolDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.Rol;
import com.bitlab.entities.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class UserManagement extends AbstractManagement<User> {

    private UserDao userDao;
    private RolDao rolDao;
    public UserManagement() {
        super(User.class);
        userDao = new UserDao();
        rolDao = new RolDao();
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
    
    public List<Rol> getRol() {
        return rolDao.findAll();
    }

}
