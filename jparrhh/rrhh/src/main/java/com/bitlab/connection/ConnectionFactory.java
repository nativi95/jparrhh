/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juana
 */
public class ConnectionFactory {

    private EntityManagerFactory factory;
    private final static ConnectionFactory cf = new ConnectionFactory();

    private ConnectionFactory() {
        factory = Persistence.createEntityManagerFactory("com.server_rrhh_war_1.0-SNAPSHOTPU");
    }

    public static ConnectionFactory getConecction() {
        return cf;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }
}
