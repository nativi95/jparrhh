/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managment;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.EmployeesDao;
import com.bitlab.entities.Employee;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andrea
 */
@ManagedBean
@ViewScoped
public class EmployeeManagement extends AbstractManagment<Employee>{

    private EmployeesDao employeeDao;
    
    public EmployeeManagement() {
        super(Employee.class);
        employeeDao = new EmployeesDao();
    }

    @Override
    public AbstractDao<Employee> getController() {
        return employeeDao;
    }
    
}
