/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.DepartmentDao;
import com.bitlab.entities.Department;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class DepartmentManagement extends AbstractManagement<Department>{

    private DepartmentDao deparmentDao;

    public DepartmentManagement() {
        super(Department.class);
        deparmentDao = new DepartmentDao();
    }

    @Override
    public DepartmentDao getController() {
        return deparmentDao;
    }

    @Override
    public Department getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Department entity) {
        this.entity = entity;
    }

    @Override
    public List<Department> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Department> entities) {
        this.entities = entities;
    }

}
