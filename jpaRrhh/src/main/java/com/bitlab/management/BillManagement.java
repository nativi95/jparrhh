/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.BillDao;
import com.bitlab.entities.Bill;
import java.util.List;
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
    public BillDao getController() {
       return billDao; 
    }

    @Override
    public Bill getEntity() {
    return entity;    
    }

    @Override
    public void setEntity(Bill entity) {
    this.entity=entity;
    }

    @Override
    public List<Bill> getEntities() {
     return entities;
    }

    @Override
    public void setEntities(List<Bill> entities) {
      this.entities=entities;  
    }
    
}
