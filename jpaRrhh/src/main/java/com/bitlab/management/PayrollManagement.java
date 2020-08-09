/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.PayrollDao;
import com.bitlab.entities.Payroll;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

}
