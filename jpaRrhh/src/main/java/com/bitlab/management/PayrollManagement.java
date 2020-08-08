/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.PayrollDao;
import com.bitlab.entities.Payroll;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class PayrollManagement extends AbstractManagement<Payroll>{
private PayrollDao payrollDao;
    public PayrollManagement() {
        super(Payroll.class);
        payrollDao = new PayrollDao();
    }

    @Override
    public AbstractDao<Payroll> getController() {
    return payrollDao;    
    }
    
}
