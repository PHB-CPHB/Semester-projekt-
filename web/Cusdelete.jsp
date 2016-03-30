<%-- 
    Document   : Cusdelete
    Created on : 30-03-2016, 13:49:02
    Author     : philliphbrink
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ServiceLayer.Entity.Building"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Bulding</title>
    </head>
    <body>
        <h1>Hello <%= session.getAttribute("Username")%></h1>
        <p>Here you have an overview of your buildings and are able to delete them</p>
        <table>
            <tr>
                <td>username</td><td>password</td><td>email</td><td>userrole</td>
            </tr>
            <% databasen db = (databasen) session.getAttribute("database");
                System.out.println("We we at A");
               ArrayList<Building> users = db.getAllUsers();
               System.out.println("We we at B");
               for ( Building building : buildings){
                   out.println("<tr>");
                   out.print("<td>" + building + "</td>");
                   out.print("<td>" + building + "</td>");
                   out.print("<td>" + building + "</td>");
                   out.println("<td>" + building + "</td>");
                   out.println("</tr>");
               } 
            %>
        </table>
    </body>
</html>
