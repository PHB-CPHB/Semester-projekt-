<%-- 
    Document   : AllUsers
    Created on : 04-04-2016, 11:47:01
    Author     : Oliver
--%>

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
    <body>
                <table>
            <tr>
                <td>username</td><td>password</td><td>email</td><td>userrole</td>
            </tr>
            <%  DBFacade DBF = (DBFacade) session.getAttribute("database");
                String username = (String) session.getAttribute("username");
                System.out.println(username);
                ArrayList<Customer> customers = new ArrayList();
                customers = DBF.getAllUsers(username);
                for (Customer customer : customers) {
                    out.println("<tr>");
                    out.println("<td>" + customer.getUsername() + "</td>");
                    out.print("<td>" + customer.getUser_role() + "</td>");
                    out.print("<td>" + customer.getUser_id() + "</td>");
                    out.print("<td>" + customer.getUser_firm() + "</td>");%>
                    <td> <form action="/AdminServlet" method="POST">
                    <input type="hidden" name="do_this" value="deleteUser"/>
                    <input type="hidden" name="RemoveCustomer" value="<%= customer.getUser_id() %>" />
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <%out.println("</tr>");
                }
            %>
        </table>
        <td> <form action="/AdminServlet" method="POST">
            <input type="hidden" name="do_this" value="return"/>
            <input type="submit" value="Return"/>
        </form>
    </td>
    </body>
</html>