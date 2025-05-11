<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Employee Outcome Page</title>
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
                text-align: center;
                max-width: 500px;
                width: 100%;
            }

            h1 {
                color: var(--primary-color);
            }

            p {
                font-size: 1.1rem;
                color: var(--secondary-color);
            }

            a {
                color: var(--accent-color);
                text-decoration: none;
                font-weight: bold;
            }

            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Employee Outcome</h1>
            <p>You successfully signed.</p>
            <p>
                Click <a href="menu_role.html">here</a> to go back to menu roles.
            </p>
        </div>
    </body>
</html>
