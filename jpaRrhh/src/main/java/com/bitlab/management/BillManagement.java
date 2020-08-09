/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.BillDao;
import com.bitlab.entities.Bill;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class BillManagement extends AbstractManagement<Bill>{
private BillDao billDao;
    public BillManagement() {
        super(Bill.class);
        billDao= new BillDao();
    }

    @Override
    public AbstractDao<Bill> getController() {
       return billDao; 
    }
    
}