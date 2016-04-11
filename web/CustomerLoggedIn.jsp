<%-- 
    Document   : CustomerLoggedIn
    Created on : 31-03-2016, 10:47:00
    Author     : Tim
--%>

<%@page import="ServiceLayer.Entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% Customer c = (Customer) session.getAttribute("LoggedInCustomer");%>
    <body bgcolor="#33CCFF">
        <h1>Hello customer <%= c.getUsername()%>.</h1>
        View my buildings <br>

        <form action="DeleteBuilding.jsp" method="POST">
            <input type="submit" value="View buildings" style="width: 30%; height: 30%; font-size: 100%;" </input>
        </form>
        <br>
        <form action="AddBuilding.jsp" method="POST">
            <input type="submit" value="Add building" style="width: 30%; height: 30%; font-size: 100%;" </input> 
        </form>
        <br>
        <form action="AdminServlet">
            <input type="submit" name="do_this" value="logout" style="width: 30%; height: 30%; font-size: 100%;">
        </form>
    </body>
</html>
