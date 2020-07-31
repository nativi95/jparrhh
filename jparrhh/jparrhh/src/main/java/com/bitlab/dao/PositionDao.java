/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.dao;

import com.bitlab.connection.ConnectionFactory;
import com.bitlab.entities.Position;
import javax.persistence.EntityManager;
/**
 *
 * @author CarlosAlex
 */
public class PositionDao extends AbstractDao<Position>{

    public PositionDao() {
        super(Position.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return ConnectionFactory.getConecction().getFactory().createEntityManager();
    }
    
}
