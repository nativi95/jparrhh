/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.DepartmentDao;
import com.bitlab.dao.EmployeeDao;
import com.bitlab.dao.PositionDao;
import com.bitlab.entities.Department;
import com.bitlab.entities.Employee;
import com.bitlab.entities.Position;
import com.bitlab.entities.User;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class EmployeeManagement extends AbstractManagement<Employee> {

    private EmployeeDao employeeDao;

    
    private DepartmentDao departmentDao;

    private PositionDao positionDao;
    
    public EmployeeManagement() {
        super(Employee.class);
        employeeDao = new EmployeeDao();
        departmentDao = new DepartmentDao();
        positionDao = new PositionDao();
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

    public List<Position> getPositions() {
        return positionDao.findAll();
    }

    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }
  
    @Override
    public void createEntity() {
        entity.setEmpEmpNo(0);
        entity.setAdatechange(new Date());
        entity.setAdatecreate(new Date());
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAusercreate(user.getUsrUser());
        entity.setAuserchange(user.getUsrUser());
        super.createEntity();
    }
    
    @Override
    public void updateEntity() {
        entity.setAdatechange(new Date());
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
        super.updateEntity();
    }
    

}
