<%-- 
    Document   : CustomerLoggedIn
    Created on : 31-03-2016, 10:47:00
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello customer <%= session.getAttribute("username") %>.</h1>
        View my buildings <br>
        <form action="CustomerBuildings.jsp" method="POST">
            <input type="submit" value="View buildings" />
    </body>
</html>
