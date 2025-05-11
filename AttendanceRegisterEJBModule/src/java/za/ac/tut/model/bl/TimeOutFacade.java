/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.Date;
import java.util.List;
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

    @Override
public TimeOut findMostFrequentTimeOut() {
    // Query to group TimeOut entries by their timeOut and count occurrences
    String jpql = "SELECT t.timeOut, COUNT(t) AS freq FROM TimeOut t GROUP BY t.timeOut ORDER BY freq DESC";
    List<Object[]> results = em.createQuery(jpql, Object[].class)
                             .setMaxResults(1)
                             .getResultList();

    if (!results.isEmpty()) {
        Date mostFrequentTime = (Date) results.get(0)[0];
        // Find a TimeOut record with this time
        return em.createQuery("SELECT t FROM TimeOut t WHERE t.timeOut = :time", TimeOut.class)
                .setParameter("time", mostFrequentTime)
                .setMaxResults(1)
                .getSingleResult();
    }
    return null;
}
}
