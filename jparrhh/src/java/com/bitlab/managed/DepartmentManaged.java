/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managed;

import com.bitlab.dao.DepartmentDao;
import com.bitlab.entities.Department;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andrea
 */
@ManagedBean
@ViewScoped
public class DepartmentManaged {
    private Department department;
    private List<Department> departmentList;
    private DepartmentDao depDao;
    
    @PostConstruct
    public void loadInfo(){
        depDao = new DepartmentDao();
        departmentList = depDao.findAll();
        
        
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    
}
