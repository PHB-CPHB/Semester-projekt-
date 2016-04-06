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
                <%--This part is writen by Phillip
                The code is to show the customers building and so that they can delete them--%>
                <td>Building ID</td><td>Building Status</td><td>Building Type</td><td>Building Year</td><td>Size</td><td>Building Name</td><td>Building Adress</td><td>Floor</td><td>Zipcode</td><td>Firm</td>
            </tr>
            <% DBFacade DBF = (DBFacade) session.getAttribute("database");
                String username = (String) session.getAttribute("username");
                System.out.println("BLABLABLABLABLABLABLABLABLA");
                ArrayList<Building> buildings = DBF.getAllCutsomerBuildings(username);
                for (Building building : buildings) {
                    out.println("<tr>");
                    out.println("<td>" + building.getBuilding_id()+ "</td>");
                    out.print("<td>" + building.getBuilding_status() + "</td>");
                    out.print("<td>" + building.getBuilding_type() + "</td>");
                    out.print("<td>" + building.getBuilding_year() + "</td>");
                    out.print("<td>" + building.getBuilding_areasize() + "</td>");
                    out.print("<td>" + building.getBuilding_name() + "</td>");
                    out.print("<td>" + building.getBuilding_adress() + "</td>");
                    out.println("<td>" + building.getBuilding_floor() + "</td>");
                    out.println("<td>" + building.getBuilding_zipcode() + "</td>");
                    out.println("<td>" + building.getBuilding_firm() + "</td>");%>
                    <%--This is the delete button--%>
            <td> <form action="DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="delete"/>
                    <input type="hidden" name="deletebuilding" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <%out.println("</tr>");
                }
            %>
        </table>
        <br>
    <td>
        <%--This is to add a building--%>
        <form action="AddBuilding.jsp">
            <input type="submit" value="Add Building"/>
        </form>
        <%--This is to return to previous site--%>
    <td> <form action="AdminLoggedIn.jsp">
            <input type="submit" value="Return"/>
        </form>
    </td>
</body>
</html>
