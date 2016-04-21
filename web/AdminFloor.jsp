<%-- 
    Document   : AdminFloor
    Created on : 13-04-2016, 21:00:12
    Author     : philliphbrink
--%>

<%@page import="ServiceLayer.Entity.Floor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ServiceLayer.Entity.Building"%>
<%@page import="ServiceLayer.Controller"%>
<%@page import="ServiceLayer.Entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Floor</title>
    </head>
    <style>table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
    </style>
    <center><h1>Here you can add or edit the different floors or you can view floor plan</h1></center>
        <% Customer c = (Customer) session.getAttribute("LoggedInCustomer");%>
    <body bgcolor="#33CCFF">
        <h1 align='center'>Hello <%= c.getUsername()%></h1>
        <p align='center'>Here you have an overview of your buildings and are able to delete them</p>
        <table style="width: 100%; background: lightblue" >
            <tr>
                <%--This part is writen by Phillip
                The code is to show the customers building and so that they can delete them
                For them to see their buildings they need user_id--%>
                <th>Floor Number</th><th>Floor size</th><th>Number of Arpartments</th><th>Total Rooms</th> <th></th> <th>
            </tr>
            <%  Controller con = (Controller) session.getAttribute("Controller");
                Building building = (Building) session.getAttribute("building");
                ArrayList<Floor> floors = con.buildingFloor(building);
                if (floors.size() == 0) {%>
            <%= "Der er sket en fejl i databasen, prøv igen senere"%>
            <%} else if (floors == null) {%>
            <%="Der er sket en fejl i databasen, kontakt support"%>
            <%} else {
                for (Floor floor : floors) {
                    out.println("<tr>");
                    out.println("<td>" + floor.getFloor_no() + "</td>");
                    out.print("<td>" + floor.getFloor_size() + "</td>");
                    out.print("<td>" + floor.getFloor_arpartments() + "</td>");
                   out.print("<td>" + floor.getFloor_rooms() + "</td>");%>
            <td> <form action="ImageController" method="POST">
                    <input type="hidden" name="" value="Floorplan"/>
                    <input type="hidden" name="floorno" value="<%= floor.getFloor_no()%>" />
                    <input type="submit" name="do_this" value="showfloors" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <td> <form action="AddBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="editFloor"/>
                    <input type="hidden" name="floorno" value="<%= floor.getFloor_no()%>" />
                    <input type="submit" value="Edit Floor" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <%-- Her slutter floors ArrayListen --%>
            <%out.println("</tr>");
                    }
                }
            %>
        </table>
        <br>
    <td> <form action="AddBuildingController" method="POST">
            <input type="hidden" name="do_this" value="addNewFloor"/>
            <input type="hidden" name="addFloor" value="<%= building.getBuilding_id()%>" />
            <input type="submit" value="Add New Floor" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </td>
    <br>
    <td>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </td>
    <% if (request.getAttribute("editFloorError") != null) {%>
    <%= request.getAttribute("editFloorError")%>
    <%}%>
</body>
</html>
