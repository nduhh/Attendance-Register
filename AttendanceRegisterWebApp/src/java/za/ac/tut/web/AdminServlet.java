/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.Employee;
import za.ac.tut.model.bl.EmployeeFacadeLocal;

/**
 *
 * @author nntem
 */
public class AdminServlet extends HttpServlet {
    @EJB EmployeeFacadeLocal efl; 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id =efl.idCreate();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String department=request.getParameter("department");
        Employee employee=new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setDepartment(department);
        Long idnew=createId(id);
        employee.setId(idnew);
        efl.create(employee);
        RequestDispatcher dispatcher=request.getRequestDispatcher("admin_outcome.jsp");
        dispatcher.forward(request, response);
    }

    private Long createId(Long id) {
        boolean check=false;
        if(!(id==null)){
          check=true;
          return  id;
        }
        else{
          id=efl.idCreate(); 
          return id;
        }
    }
}
