/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ManagerServlet extends HttpServlet {
    @EJB EmployeeFacadeLocal efl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employees=efl.findAll();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher=request.getRequestDispatcher("manager_outcome.jsp");
        dispatcher.forward(request, response);
    }

}
