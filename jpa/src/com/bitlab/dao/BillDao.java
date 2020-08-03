/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Bill;
import javax.persistence.EntityManager;

/**
 *
 * @author juana
 */
public class BillDao extends AbstractDao<Bill>{

    public BillDao() {
        super(Bill.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }
    
}
