/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Rol;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author juana
 */
public class RolDao extends AbstractDao<Rol> {

    private static final Logger logger = LoggerFactory.getLogger(RolDao.class);

    public RolDao() {
        super(Rol.class);
        logger.debug("Se inicia metodo constructor");
    }

    @Override
    public EntityManager getEntityManager() {
        logger.debug("Se inicia Get Entity Manager");
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

}
