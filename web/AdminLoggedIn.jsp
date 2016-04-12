<%-- 
    Document   : AdminLoggedIn
    Created on : 31-03-2016, 10:45:27
    Author     : Oliver
--%>

<%@page import="ServiceLayer.Entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%-- Made by phillip - To Show Username --%>
    <%Customer c = (Customer) session.getAttribute("LoggedInCustomer");%>
    <body bgcolor="#33CCFF">
        <h1>Hello admin <%= c.getUsername() %>.</h1>
        <form action="CreateUser.jsp">
            <input type="submit" name="dothis" value="Create User" style="width: 30%; height: 30%; font-size: 100%;">
        </form>
        <br>
            <form action="AllUsers.jsp">
                <input type="submit" name="dothis" value="View User" style="width: 30%; height: 30%; font-size: 100%;">
            </form>
        <br>
        <form action="AdminBuildings.jsp">
            <input type="submit" name="dothis" value="View Buildings" style="width: 30%; height: 30%; font-size: 100%;">
        </form>
        <br>
        <form action="AdminServlet" method="POST">
            <input type="submit" name="do_this" value="logout" style="width: 30%; height: 30%; font-size: 100%;">
        </form>
    </body>
</html>
