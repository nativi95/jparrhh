/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Department;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrea
 */
public class DepartmentDao extends AbstractDao<Department> {

    private static Logger logger = LoggerFactory.getLogger(DepartmentDao.class);

    public DepartmentDao() {
        super(Department.class);
        logger.debug("Se inicia metodo constructor");
    }

    @Override
    public EntityManager getEntityManager() {
        logger.debug("Se inicia Get Entity Manager");
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

}
