<%-- 
    Document   : Cusdelete
    Created on : 30-03-2016, 13:49:02
    Author     : philliphbrink
--%>

<%@page import="DataAccessLayer.DBFacade"%>
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
        <h1>Hello <%= session.getAttribute("username")%></h1>
        <p>Here you have an overview of your buildings and are able to delete them</p>
        <table>
            <tr>
                <td>username</td><td>password</td><td>email</td><td>userrole</td>
            </tr>
            <% DBFacade DBF = (DBFacade) session.getAttribute("database");
                String customers_name = (String) session.getAttribute("username");

                ArrayList<Building> buildings = DBF.getAllCutsomerBuildings(customers_name);
                for (Building building : buildings) {
                    out.println("<tr>");
                    out.println("<td>" + building.getBuildingId() + "</td>");
                    out.print("<td>" + building.getAdress() + "</td>");
                    out.print("<td>" + building.getBuildingName() + "</td>");
                    out.print("<td>" + building.getBuildingStatus() + "</td>");
                    out.println("<td>" + building.getCity() + "</td>");
                    out.println("<td>" + building.getZipCode() + "</td>");%>
            <td> <form action="/DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="delete"/>
                    <input type="hidden" name="deletebuilding" value="<%= building.getBuildingId()%>" />
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <%out.println("</tr>");
                }
            %>
        </table>
    <td> <form action="/DeleteBuildingController" method="POST">
            <input type="hidden" name="do_this" value="return"/>
            <input type="submit" value="Return"/>
        </form>
    </td>
</body>
</html>
