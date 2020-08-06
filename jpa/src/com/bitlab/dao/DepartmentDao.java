/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Department;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andrea
 */
public class DepartmentDao extends AbstractDao<Department>{

    public DepartmentDao() {
        super(Department.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }

    @Override
    public List<Department> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Department find(Object id) throws Exception {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Department entity) throws Exception {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Department entity) throws Exception {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Department entity) throws Exception {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
}
