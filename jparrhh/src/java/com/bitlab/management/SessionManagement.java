/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.User;
import java.io.IOException;
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
    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();//Permitira realizar la redirecion y la sesion
    private String route = null;//sera la ruta a donde enciara

    public SessionManagement() {
        super(User.class);
        this.userDao = new UserDao();
    }

    public void LogIn() {
        userDao = new UserDao();
        setEntity(userDao.login(getEntity()));//se llena entity con la busqueda del login

        if (getEntity() != null) {
            externalContext.getSessionMap().put("User", getEntity());// se crea sesion con objeto de tipo user y clave User

            if (getEntity().getUsrRolNo().getRolRolNo() == 1) {
                redirect("rrhh/index");
            } else {
                redirect("admin/index");
            }
            try {
                externalContext.redirect(route);//envia al xhtml segun ruta
                message("Sesión iniciada", "Bienvenido " + getEntity().getUsrUser(), "INFO");
            } catch (IOException ex) {
                Logger.getLogger(SessionManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            message("No se pudo iniciar sesión", "Algunos de los datos no esta correcto", "WARN");
        }

    }

    public void checkSession(int rol) {
        userDao = new UserDao();
        String route = null;
        setEntity((User) externalContext.getSessionMap().get("User"));//se obtiene la sesion actual
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
    public AbstractDao<User> getController() {
        return userDao;
    }

}
