<%--  
    Document   : id_search_outcome
    Created on : 10 May 2025, 9:50:15 PM
    Author     : nntem
--%>

<%@page import="za.ac.tut.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Employee Details Page</title>
        <style>
            :root {
                --primary-color: #2c3e50;
                --secondary-color: #34495e;
                --accent-color: #3498db;
                --light-bg: #ecf0f1;
                --text-color: #333;
                --button-color: #2980b9;
                --button-hover: #1c6ca1;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: var(--light-bg);
                color: var(--text-color);
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                background: white;
                padding: 2rem 3rem;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                max-width: 500px;
                width: 100%;
            }

            h1 {
                color: var(--primary-color);
                text-align: center;
            }

            p {
                font-size: 1.1rem;
                text-align: center;
                color: var(--secondary-color);
            }

            table {
                margin: 1.5rem auto;
            }

            td {
                padding: 0.5rem;
                font-size: 1rem;
            }

            select, input[type="submit"] {
                padding: 0.4rem 0.6rem;
                font-size: 1rem;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            input[type="submit"] {
                background-color: var(--button-color);
                color: white;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: var(--button-hover);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Employee</h1>
            <%
                Employee employee = (Employee) request.getAttribute("employee");
                Long id = employee.getId();
                String name = employee.getName();
                String surname = employee.getSurname();
                String department = employee.getDepartment();
            %>
            <p>
                Hi! <strong><%= name %> <%= surname %></strong> from the <strong><%= department %></strong> department.
            </p>
            <form action="TimeServlet.do" method="POST">
                <table>
                    <tr>
                        <td>Signing:</td>
                        <td>
                            <select name="time">
                                <option value="in">In</option> 
                                <option value="out">Out</option> 
                            </select>
                        </td>
                        <td>
                            <input type="hidden" name="id" value="<%= id %>" required>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <input type="submit" value="SUBMIT">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
