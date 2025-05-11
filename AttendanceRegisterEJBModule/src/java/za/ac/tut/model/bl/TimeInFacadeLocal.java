/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.TimeIn;

/**
 *
 * @author nntem
 */
@Local
public interface TimeInFacadeLocal {

    void create(TimeIn timeIn);

    void edit(TimeIn timeIn);

    void remove(TimeIn timeIn);

    TimeIn find(Object id);

    List<TimeIn> findAll();

    List<TimeIn> findRange(int[] range);

    int count();
    TimeIn findMostFrequentTimeIn();
    
}
