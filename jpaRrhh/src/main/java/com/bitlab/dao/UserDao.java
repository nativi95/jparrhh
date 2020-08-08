/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Rol;
import com.bitlab.entities.User;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 *
 * @author juana
 */
public class UserDao extends AbstractDao<User> {
//private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public UserDao() {
        super(User.class);
//        logger.debug("Se inicia metodo constructor");
    }

    @Override
    public EntityManager getEntityManager() {
//        logger.debug("Se inicia Get Entity Manager");
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

    public User login(User input) {
//         logger.debug("Se obtiene Entity Manager");
        EntityManager em = getEntityManager();
//        logger.debug("Se Crea la Consulta");
        String sql = "SELECT u FROM User AS u JOIN u.usrRolNo r WHERE u.usrUser=?1 AND u.userPassword=?2";
        Query q = null;
        try {
q=em.createQuery(sql, User.class);
q.setParameter(1, input.getUsrUser());
q.setParameter(1, input.getUserPassword());
            return (User)q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (em.isOpen()) {
                //logger.debug("Cerrando Conexion");
                em.close();
                //logger.debug("Conexion Cerrada");
            }
        }

    }
}
