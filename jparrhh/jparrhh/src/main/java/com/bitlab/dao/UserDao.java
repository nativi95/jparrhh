/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.User;
import static com.mysql.cj.conf.PropertyKey.logger;
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

    public User login(User u) {
        String sql = "SELECT u.usrUserNo, u.usrUser, r.rolRolNo, r.rolRol FROM User u JOIN u.usrRolNo r where  u.usrUser=?1 and u.userPassword=?2";
        try {
            Query q = getEntityManager().createQuery(sql, User.class);
            q.setParameter("1", u.getUsrUser());
            q.setParameter("2", u.getUserPassword());
            u = null;
            u = (User) q.getSingleResult();
            if (u != null) {
                return u;
            } else {
                return null;
            }
        } catch (Exception e) {
          return null;  
        }
    }

}
