/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.EmployeeDao;
import com.bitlab.entities.Employee;
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

}
