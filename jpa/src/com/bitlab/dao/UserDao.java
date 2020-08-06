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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author juana
 */
public class UserDao extends AbstractDao<User> {
private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public UserDao() {
        super(User.class);
        logger.debug("Se inicia metodo constructor");
    }

    @Override
    public EntityManager getEntityManager() {
        logger.debug("Se inicia Get Entity Manager");
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

    public User login(User input) {
         logger.debug("Se obtiene Entity Manager");
        EntityManager em = getEntityManager();
        logger.debug("Se Crea la Consulta");
        String sql = "SELECT u.usrUserNo, u.usrUser, u.ausercreate, u.adatecreate, u.auserchange, u.adatechange, r.rolRolNo, r.rolRol FROM User AS u JOIN u.usrRolNo r WHERE u.usrUser=?1 AND u.userPassword=?2";
        Query q = null;
        try {
             logger.debug("Se crea Query  de tipo User");
            q = em.createQuery(sql, User.class);
            logger.debug("Se setea el primer valor");
            q.setParameter(1, input.getUsrUser());
            logger.debug("Se setea el segundo valor");
            q.setParameter(2, input.getUserPassword());
            List<Object[]> list = q.getResultList();
            logger.debug("Se obtuvieron datos en una lista");
            User u = null;
            Rol r;
            
            for (Object[] obj : list) {
                logger.debug("Recorriendo la Lista");
                u = new User((Integer) obj[0]);
                logger.debug("Creando Nuevo Usuario");
                u.setUsrUser((String) obj[1]);
                logger.debug("Setea Nombre de Usuario");
                u.setAusercreate((String) obj[2]);
                logger.debug("Setea Usuario Creador");
                u.setAdatecreate((Date) obj[3]);
                logger.debug("Setea Fecha de Creacion");
                u.setAuserchange((String) obj[4]);
                logger.debug("Setea Usuario que ha cambia datos");
                u.setAdatechange((Date) obj[5]);
                logger.debug("Setea Fecha de Cambio de datos");
                r = new Rol((Integer) obj[6]);
                logger.debug("Creando Rol de Usuario");
                r.setRolRol((String) obj[7]);
                logger.debug("Setea Rol de Usuario");
                u.setUsrRolNo(r);
               
            }
            return u;
        } catch (Exception e) {
            return null;
        } finally {
            if (em.isOpen()) {
                logger.debug("Cerrando Conexion");
                em.close();
                logger.debug("Conexion Cerrada");
            }
        }

    }
}
