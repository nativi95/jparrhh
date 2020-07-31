/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.managment;

import com.bitlab.dao.AbstractDao;
import com.bitlab.dao.PositionDao;
import com.bitlab.entities.Position;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CarlosAlex
 */
@ManagedBean
@ViewScoped
public class PositionManagement extends AbstractManagment<Position> {
    private PositionDao positionDao;

    public PositionManagement() {
        super(Position.class);
        positionDao = new PositionDao();

    }

    @Override
    public AbstractDao<Position> getController() {
        return positionDao;
    }
}
