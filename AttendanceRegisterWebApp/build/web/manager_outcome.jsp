<%-- 
    Document   : manager_outcome.jsp
    Created on : 11 May 2025, 12:52:15 AM
    Author     : nntem
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="za.ac.tut.entity.TimeOut"%>
<%@page import="za.ac.tut.entity.TimeIn"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Employee Time Tracking Report</title>
        <style>
            :root {
                --primary-color: #2c3e50;
                --secondary-color: #34495e;
                --accent-color: #3498db;
                --text-color: #333;
                --light-bg: #ecf0f1;
                --card-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                --hover-color: #2980b9;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 2rem;
                background-color: var(--light-bg);
                color: var(--text-color);
            }

            h1 {
                text-align: center;
                color: var(--primary-color);
                font-size: 2rem;
                margin-bottom: 1.5rem;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                box-shadow: var(--card-shadow);
                background: white;
                border-radius: 8px;
                overflow: hidden;
            }

            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: var(--accent-color);
                color: white;
                position: sticky;
                top: 0;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            .time-cell {
                white-space: nowrap;
            }

            .no-data {
                color: #999;
                font-style: italic;
            }

            a {
                color: var(--accent-color);
                text-decoration: none;
                font-weight: 600;
            }

            a:hover {
                color: var(--hover-color);
                text-decoration: underline;
            }

            .footer {
                margin-top: 2rem;
                text-align: center;
                color: white;
                background-color: var(--primary-color);
                padding: 1rem;
            }

        </style>
    </head>
    <body>
        <h1>Employee Time Tracking Report</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Department</th>
                    <th>Time In</th>
                    <th>Time Out</th>
                    <th>Duration</th>
                </tr>
            </thead>
            <tbody>
            <%
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");

                if (employees == null || employees.isEmpty()) {
            %>
                <tr>
                    <td colspan="6" class="no-data">No employee data available</td>
                </tr>
            <%
                } else {
                    for (Employee employee : employees) {
                        List<TimeIn> timeIns = employee.getTimeIns();
                        List<TimeOut> timeOuts = employee.getTimeOuts();
                        int maxEntries = Math.max(timeIns.size(), timeOuts.size());

                        for (int i = 0; i < maxEntries; i++) {
            %>
                <tr>
                    <% if (i == 0) { %>
                        <td rowspan="<%= maxEntries > 0 ? maxEntries : 1 %>"><%= employee.getName() %></td>
                        <td rowspan="<%= maxEntries > 0 ? maxEntries : 1 %>"><%= employee.getSurname() %></td>
                        <td rowspan="<%= maxEntries > 0 ? maxEntries : 1 %>"><%= employee.getDepartment() %></td>
                    <% } %>

                    <td class="time-cell">
                        <% if (i < timeIns.size() && timeIns.get(i) != null) { %>
                            <%= sdf.format(timeIns.get(i).getTimeIn()) %>
                        <% } else { %>
                            <span class="no-data">N/A</span>
                        <% } %>
                    </td>

                    <td class="time-cell">
                        <% if (i < timeOuts.size() && timeOuts.get(i) != null) { %>
                            <%= sdf.format(timeOuts.get(i).getTimeOut()) %>
                        <% } else { %>
                            <span class="no-data">N/A</span>
                        <% } %>
                    </td>

                    <td class="time-cell">
                        <% if (i < timeIns.size() && i < timeOuts.size()
                                && timeIns.get(i) != null && timeOuts.get(i) != null) {
                            long duration = timeOuts.get(i).getTimeOut().getTime() - 
                                            timeIns.get(i).getTimeIn().getTime();
                            long hours = duration / (60 * 60 * 1000);
                            long minutes = (duration % (60 * 60 * 1000)) / (60 * 1000);
                        %>
                            <%= hours %>h <%= minutes %>m
                        <% } else { %>
                            <span class="no-data">N/A</span>
                        <% } %>
                    </td>
                </tr>
            <%
                        }
                    }
                }
            %>
            </tbody>
        </table>
        <p>
            Click <a href="menu_role.html">here</a> to go back to the menu roles.
        </p>
        <div class="footer">
            Report generated on: <%= sdf.format(new Date()) %>
        </div>
    </body>
</html>
