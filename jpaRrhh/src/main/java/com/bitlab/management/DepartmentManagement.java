/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.DepartmentDao;
import com.bitlab.entities.Department;
import com.bitlab.entities.User;
import java.io.Serializable;
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
public class DepartmentManagement extends AbstractManagement<Department> implements Serializable {

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

    @Override
    public void createEntity() {
        entity.setDepDeptNo(0);
        entity.setAdatechange(new Date());
        entity.setAdatecreate(new Date());
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAusercreate(user.getUsrUser());
        entity.setAuserchange(user.getUsrUser());
        super.createEntity();
    }

}
