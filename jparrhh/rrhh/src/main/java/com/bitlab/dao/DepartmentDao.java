/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Department;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrea
 */
public class DepartmentDao extends AbstractDao<Department>{

    public DepartmentDao(Class<Department> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }
    
}
