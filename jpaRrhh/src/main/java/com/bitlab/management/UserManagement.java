/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class UserManagement extends AbstractManagement<User>{
    private UserDao userDao;
    public UserManagement() {
        super(User.class);
        userDao= new UserDao();
    }

    @Override
    public AbstractDao<User> getController() {
       return userDao; 
    }
}
