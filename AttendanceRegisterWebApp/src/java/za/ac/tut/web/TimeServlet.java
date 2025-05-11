/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.Employee;
import za.ac.tut.entity.TimeIn;
import za.ac.tut.entity.TimeOut;
import za.ac.tut.model.bl.EmployeeFacadeLocal;

/**
 *
 * @author nntem
 */
public class TimeServlet extends HttpServlet {
    @EJB EmployeeFacadeLocal efl; 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String time=request.getParameter("time");
        Long id=Long.parseLong(request.getParameter("id"));
        Employee employee=efl.find(id);
        check(time,employee);
        efl.edit(employee);
        RequestDispatcher dispatcher=request.getRequestDispatcher("employee_outcome.jsp");
        dispatcher.forward(request, response);
    }

    private void check(String time,Employee employee) {
        
        if(time.equals("in")){
            List<TimeIn> ins=employee.getTimeIns();
            ins.add(new TimeIn(new Date()));
            employee.setTimeIns(ins);
        }
        else{
            List<TimeOut> outs=employee.getTimeOuts();
            outs.add(new TimeOut(new Date()));
            employee.setTimeOuts(outs);
        }
    }
}
