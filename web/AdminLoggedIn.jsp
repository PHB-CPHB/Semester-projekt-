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
        <h1><a href="CreateUser.jsp">Create an user</a></h1>
        <h1><a href="AllUsers.jsp">Show users</a></h1>
        <h1><a href="Cusdelete.jsp">Show buildings</a></h1>
    </body>
</html>
