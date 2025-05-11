/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.TimeOut;

/**
 *
 * @author nntem
 */
@Stateless
public class TimeOutFacade extends AbstractFacade<TimeOut> implements TimeOutFacadeLocal {

    @PersistenceContext(unitName = "AttendanceRegisterEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimeOutFacade() {
        super(TimeOut.class);
    }
    
}
