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
        <form action="CreateUser.jsp">
            <input type="submit" name="dothis" value="Create User">
        </form>
        <br>
            <form action="AllUsers.jsp">
                <input type="submit" name="dothis" value="View User">
            </form>
        <br>
        <form action="DeleteBuilding.jsp">
            <input type="submit" name="dothis" value="View Buildings">
        </form>
        <br>
        <form action="AdminServlet">
            <input type="submit" name="do_this" value="logout">
        </form>
    </body>
</html>
