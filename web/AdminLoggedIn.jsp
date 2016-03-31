<%-- 
    Document   : AdminLoggedIn
    Created on : 31-03-2016, 10:45:27
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
        <h1>Hello admin <%= session.getAttribute("username")%>.</h1>
        <form action="CreateUser.jsp" method="POST">
            <input type="submit" value="Create user" />
    </body>
</html>
