<%-- 
    Document   : Cusdelete
    Created on : 30-03-2016, 13:49:02
    Author     : philliphbrink
--%>

<%@page import="ServiceLayer.Entity.Customer"%>
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
    <% Customer c = (Customer) session.getAttribute("LoggedInCustomer");%>
    <body>
        <h1>Hello <%= c.getUsername()%></h1>
        <p>Here you have an overview of your buildings and are able to delete them</p>
        <table>
            <tr>
                <%--This part is writen by Phillip
                The code is to show the customers building and so that they can delete them
                For them to see their buildings they need user_id--%>
                <td>Building ID</td><td>Building Status</td><td>Building Type</td><td>Building Year</td><td>Size</td><td>Building Name</td><td>Building Adress</td><td>Floor</td><td>Zipcode</td><td>Firm</td>
            </tr>
            <% DBFacade DBF = (DBFacade) session.getAttribute("database");
                ArrayList<Building> buildings = DBF.getAllCutsomerBuildings(c);
                for (Building building : buildings) {
                    out.println("<tr>");
                    out.println("<td>" + building.getBuilding_id() + "</td>");
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
            <td> <form action="DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="report"/>
                    <input type="hidden" name="viewreport" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="View reports"/>
                </form>
            </td>
            <td> <form action="Floorplan.jsp" method="POST">
                    <input type="hidden" name="" value="Floorplan"/>
                    <input type="hidden" name="deletebuilding" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="Floorplan"/>
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
    <td> <form action="DeleteBuildingController" method="POST">
            <input type="submit" name="do_this" value="Return"/>
        </form>
    </td>
</body>
</html>
