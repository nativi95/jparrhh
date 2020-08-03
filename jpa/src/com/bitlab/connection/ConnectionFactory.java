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
 * @author nativi
 */
public class ConnectionFactory {
    private EntityManagerFactory factory;
    private static ConnectionFactory cnf= new ConnectionFactory();
    
    private ConnectionFactory(){
    factory = Persistence.createEntityManagerFactory("jpaPU");
    }
    
    public static ConnectionFactory getConecction(){
    return cnf;
    }
    
    public EntityManagerFactory getFactory(){
    return factory;
    }
}
