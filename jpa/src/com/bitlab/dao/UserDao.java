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

/**
 *
 * @author juana
 */
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

    public User login(User input) {
        EntityManager em = getEntityManager();
        String sql = "SELECT u.usrUserNo, u.usrUser, u.ausercreate, u.adatecreate, u.auserchange, u.adatechange, r.rolRolNo, r.rolRol FROM User AS u JOIN u.usrRolNo r WHERE u.usrUser=?1 AND u.userPassword=?2";
        Query q = null;
        try {
            q = em.createQuery(sql, User.class);
            q.setParameter(1, input.getUsrUser());
            q.setParameter(2, input.getUserPassword());
            List<Object[]> list = q.getResultList();
            User u = null;
            Rol r;
            for (Object[] obj : list) {
                u = new User((Integer) obj[0]);
                u.setUsrUser((String) obj[1]);
                u.setAusercreate((String) obj[2]);
                u.setAdatecreate((Date) obj[3]);
                u.setAuserchange((String) obj[4]);
                u.setAdatechange((Date) obj[5]);
                r = new Rol((Integer) obj[6]);
                r.setRolRol((String) obj[7]);
                u.setUsrRolNo(r);
            }
            return u;
        } catch (Exception e) {
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }
}
