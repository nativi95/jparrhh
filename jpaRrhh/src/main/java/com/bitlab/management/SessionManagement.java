/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.Utils.Sha;
import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author nativi
 */
@ManagedBean
@SessionScoped
public class SessionManagement extends AbstractManagement<User> {

    private UserDao userDao;

    public SessionManagement() {
        super(User.class);
        this.userDao = new UserDao();
        try {
            newEntity();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SessionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logIn() {
        userDao = new UserDao();
        
        entity.setUserPassword(Sha.encrypt(entity.getUserPassword()));
        
        entity = userDao.login(entity);//se llena entity con la busqueda del login
        
        if (entity != null) {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", entity);// se crea sesion con objeto de tipo user y clave User

            if (entity.getUsrRolNo().getRolRolNo() == 1) {
                redirect("rrhh/index");
            } else {

                redirect("admin/index");

            }

            message("Sesión iniciada", "Bienvenido " + entity.getUsrUser(), "INFO");

        } else {
            message("No se pudo iniciar sesión", "Algunos de los datos no esta correcto", "WARN");

            entity = new User();

        }

    }

    public void checkSession(int rol) {
        userDao = new UserDao();

        setEntity((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User"));//se obtiene la sesion actual
        if (getEntity() != null) {
            if (getEntity().getUsrRolNo().getRolRolNo() == rol) {

            } else {
                if (getEntity().getUsrRolNo().getRolRolNo() == 1) {
                    redirect("rrhh/index");

                } else {
                    redirect("admin/index");

                }
            }
        } else {

            redirect("index");
        }

    }

    public void logOut() {

        redirect("index");

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

}
