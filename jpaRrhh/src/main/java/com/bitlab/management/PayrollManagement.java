/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.PayrollDao;
import com.bitlab.entities.Payroll;
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
public class PayrollManagement extends AbstractManagement<Payroll> {

    private PayrollDao payrollDao;

    public PayrollManagement() {
        super(Payroll.class);
        payrollDao = new PayrollDao();
    }

    @Override
    public PayrollDao getController() {
        return payrollDao;
    }

    @Override
    public Payroll getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Payroll entity) {
        this.entity = entity;
    }

    @Override
    public List<Payroll> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Payroll> entities) {
        this.entities = entities;
    }
    
    @Override
    public void createEntity() {
        entity.setPayPayrollNo(0);
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
