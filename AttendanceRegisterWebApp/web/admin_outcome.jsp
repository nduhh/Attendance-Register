<%-- 
    Document   : admin_outcome
    Created on : 11 May 2025, 12:08:35 AM
    Author     : nntem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Outcome Page</title>
        <style>
            :root {
                --primary-color: #2c3e50;
                --secondary-color: #34495e;
                --accent-color: #3498db;
                --text-color: #333;
                --light-bg: #f5f7fa;
                --input-border: #ddd;
                --error-color: #e74c3c;
                --success-color: #2ecc71;
                --shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                line-height: 1.6;
                color: var(--text-color);
                background-color: var(--light-bg);
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            .container {
                max-width: 500px;
                margin: 2rem auto;
                padding: 2rem;
                background: white;
                border-radius: 8px;
                box-shadow: var(--shadow);
            }

            h1 {
                color: var(--primary-color);
                text-align: center;
                margin-bottom: 1.5rem;
                font-size: 2rem;
            }

            p {
                text-align: center;
                color: var(--secondary-color);
                font-size: 1.1rem;
                margin-bottom: 2rem;
            }

            a {
                color: var(--accent-color);
                text-decoration: none;
                font-weight: 600;
            }

            a:hover {
                text-decoration: underline;
            }

            footer {
                text-align: center;
                padding: 1rem;
                margin-top: auto;
                background-color: var(--primary-color);
                color: white;
            }

            @media (max-width: 600px) {
                .container {
                    margin: 1rem;
                    padding: 1.5rem;
                }

                h1 {
                    font-size: 1.8rem;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Administration Outcome</h1>
            <p>
                Successfully added a new employee!
            </p>
            <p>
                Click <a href="menu_role.html">here</a> to go back to the menu roles.
            </p>
            <p>
                Click <a href="administration.html">here</a> to add another new employee.
            </p>
        </div>
        
        <footer>
            <span id="datetime"></span> | Employee Management System
            <script>
                function updateDateTime() {
                    const now = new Date();
                    const options = {
                        weekday: 'long',
                        year: 'numeric',
                        month: 'long',
                        day: 'numeric',
                        hour: '2-digit',
                        minute: '2-digit',
                        second: '2-digit'
                    };
                    document.getElementById('datetime').textContent = now.toLocaleString(undefined, options);
                }

                updateDateTime();
                setInterval(updateDateTime, 1000); // Update every second
            </script>
        </footer>
    </body>
</html>
