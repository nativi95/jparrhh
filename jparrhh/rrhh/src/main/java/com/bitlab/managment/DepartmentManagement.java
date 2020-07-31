/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managment;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.DepartmentDao;
import com.bitlab.entities.Department;

/**
 *
 * @author Andrea
 */
public class DepartmentManagement extends AbstractManagment<Department>{

    private DepartmentDao departmentDao;
    
    public DepartmentManagement() {
        super(Department.class);
        departmentDao = new DepartmentDao();
    }

    @Override
    public AbstractDao<Department> getController() {
        return departmentDao;
    }
    
}
