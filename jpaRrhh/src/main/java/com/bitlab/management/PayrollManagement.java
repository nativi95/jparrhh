/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.PayrollDao;
import com.bitlab.entities.Employee;
import com.bitlab.entities.Payroll;
import com.bitlab.entities.User;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class PayrollManagement extends AbstractManagement<Payroll> {

    private PayrollDao payrollDao;
    private User user;
    private Employee employee;
    private int id;
    private Flash flash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
            
            
    

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

   public void onPageLoad() 
       {
           flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

           id = ((int) flash.get("id"));

           flash.putNow("id", id);

           flash.keep("id");
       }
    
    

    @Override
    public void createEntity() {
        entity.setPayPayrollNo(0);
        autoSet();
        entity.setAdatecreate(new Date());
        entity.setAusercreate(user.getUsrUser());
        user = null;
        super.createEntity();
    }

    @Override
    public void updateEntity() {
        autoSet();
        user = null;
        super.updateEntity();
    }

    public void autoSet() {
        entity.setAdatechange(new Date());
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
    }

}
