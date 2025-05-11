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
import za.ac.tut.entity.TimeIn;

/**
 *
 * @author nntem
 */
@Stateless
public class TimeInFacade extends AbstractFacade<TimeIn> implements TimeInFacadeLocal {

    @PersistenceContext(unitName = "AttendanceRegisterEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimeInFacade() {
        super(TimeIn.class);
    }

   @Override
public TimeIn findMostFrequentTimeIn() {
    // Query to group TimeIn entries by their timeIn and count occurrences
    String jpql = "SELECT t.timeIn, COUNT(t) AS freq FROM TimeIn t GROUP BY t.timeIn ORDER BY freq DESC";
    List<Object[]> results = em.createQuery(jpql, Object[].class)
                             .setMaxResults(1)
                             .getResultList();

    if (!results.isEmpty()) {
        Date mostFrequentTime = (Date) results.get(0)[0];
        // Find a TimeIn record with this time
        return em.createQuery("SELECT t FROM TimeIn t WHERE t.timeIn = :time", TimeIn.class)
                .setParameter("time", mostFrequentTime)
                .setMaxResults(1)
                .getSingleResult();
    }
    return null;
}
    
}
