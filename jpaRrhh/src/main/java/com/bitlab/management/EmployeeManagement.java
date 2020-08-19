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
import javax.faces.context.ExternalContext;
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

    private User user;
    int id;

    private Position position;
    private Department department;

    public EmployeeManagement() {
        super(Employee.class);
        employeeDao = new EmployeeDao();
        departmentDao = new DepartmentDao();
        positionDao = new PositionDao();
        position = new Position();
        department = new Department();
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void createEntity() {
        entity.setEmpEmpNo(0);
        autoSet();
        entity.setAdatecreate(new Date());
        entity.setAusercreate(user.getUsrUser());
        user = null;
        super.createEntity();
    }

    @Override
    public void updateEntity() {
        autoSet();
        super.updateEntity();
    }

    public void autoSet() {
        entity.setAdatechange(new Date());
        entity.setEmpDeptNo(department);
        department = new Department();
        entity.setEmpPositionNo(position);
        position = new Position();
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
    }

    public String showProfile(int id) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.getFlash().put("id", id);
        return "profileView?faces-redirect=true";
    }

}
