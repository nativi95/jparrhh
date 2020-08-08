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
