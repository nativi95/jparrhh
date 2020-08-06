/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.management;

import com.bitlab.dao.AbstractDao;
import com.bitlab.entities.Rol;
import com.bitlab.dao.RolDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author nativi
 */
@ManagedBean
@ViewScoped
public class RolManagement extends AbstractManagement<Rol>{
    
    private RolDao rolDao;

    public RolManagement() {
        super(Rol.class);
        rolDao = new RolDao();
    }

    @Override
    public AbstractDao<Rol> getController() {
    return rolDao;
    }
    
}
