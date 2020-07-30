/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managment;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.BillDao;
import com.bitlab.entities.Bill;

/**
 *
 * @author juana
 */
public class BillManagement extends AbstractManagment<Bill> {

    private BillDao billDao;

    public BillManagement() {
        super(Bill.class);
        billDao = new BillDao();

    }

    @Override
    public AbstractDao<Bill> getController() {
        return billDao;
    }

}
