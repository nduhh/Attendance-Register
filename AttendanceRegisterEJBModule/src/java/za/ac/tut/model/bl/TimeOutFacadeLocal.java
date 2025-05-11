/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.TimeOut;

/**
 *
 * @author nntem
 */
@Local
public interface TimeOutFacadeLocal {

    void create(TimeOut timeOut);

    void edit(TimeOut timeOut);

    void remove(TimeOut timeOut);

    TimeOut find(Object id);

    List<TimeOut> findAll();

    List<TimeOut> findRange(int[] range);

    int count();
    
}
