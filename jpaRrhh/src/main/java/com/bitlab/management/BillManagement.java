/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.BillDao;
import com.bitlab.entities.Bill;
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
public class BillManagement extends AbstractManagement<Bill> {

    private BillDao billDao;

    public BillManagement() {
        super(Bill.class);
        billDao = new BillDao();
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
        this.entity = entity;
    }

    @Override
    public List<Bill> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Bill> entities) {
        this.entities = entities;
    }

    @Override
    public void createEntity() {
        entity.setBillBillNo(0);
        entity.setAdatechange(new Date());
        entity.setAdatecreate(new Date());

        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
        entity.setAusercreate(user.getUsrUser());
        super.createEntity();
    }

    @Override
    public void updateEntity() {
        entity.setBillBillNo(0);
        entity.setAdatechange(new Date());

        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        entity.setAuserchange(user.getUsrUser());
        super.updateEntity();
    }
}
