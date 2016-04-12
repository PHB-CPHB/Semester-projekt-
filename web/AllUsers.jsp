<%-- 
    Document   : AllUsers
    Created on : 04-04-2016, 11:47:01
    Author     : Oliver
--%>

<%@page import="ServiceLayer.Controller"%>
<%@page import="ServiceLayer.Entity.Building"%>
<%@page import="ServiceLayer.Entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataAccessLayer.DBFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%-- Style made by Phillip --%>
    <style>table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
    </style>
    <body bgcolor="#33CCFF">
        <table style="width: 100%; background: lightblue">
            <tr>
                <th>Username</th><th>User Role</th><th>User ID</th><th>User Firm</th><th> </th>
            </tr>
            <%-- Made by Oliver --%>
            <%  Controller con = (Controller) session.getAttribute("Controller");
                Customer LoggedInCustomer = (Customer) session.getAttribute("LoggedInCustomer");
                ArrayList<Customer> customers = con.getAllUsers(LoggedInCustomer);
                customers = con.getAllUsers(LoggedInCustomer);

                for (Customer customer : customers) {
                    out.println("<tr>");
                    out.println("<td>" + customer.getUsername() + "</td>");
                    out.print("<td>" + customer.getUser_role() + "</td>");
                    out.print("<td>" + customer.getUser_id() + "</td>");
                    out.print("<td>" + customer.getUser_firm() + "</td>");%>
            <td> <form action="AdminServlet" method="POST">
                    <input type="hidden" name="do_this" value="deleteUser"/>
                    <input type="hidden" name="RemoveCustomer" value="<%= customer.getUser_id()%>" />

                    <%-- Made by Michael --%>
                    <input type="hidden" name="deletebuilding" value="<%= customer.getUsername()%>" />
                    <input type="submit" value="Delete" style="width: 100%; background: white; font-size: 110% "/>
                </form>
            </td>
            <%out.println("</tr>");
                }
            %>
        </table>
    <td> <form action="AdminLoggedIn.jsp" method="POST">

            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </td>
</body>
</html>
