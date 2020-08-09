/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.EmployeeDao;
import com.bitlab.entities.Employee;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class EmployeeManagement extends AbstractManagement<Employee> {

    private EmployeeDao employeeDao;

    public EmployeeManagement() {
        super(Employee.class);
        employeeDao = new EmployeeDao();
    }

    @Override
    public EmployeeDao getController() {
        return employeeDao;
    }

    @Override
    public Employee getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Employee entity) {

        this.entity = entity;
    }

    @Override
    public List<Employee> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Employee> entities) {
        this.entities = entities;
    }

}
