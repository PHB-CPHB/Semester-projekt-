<%-- 
    Document   : CustomerBuildings
    Created on : 31-03-2016, 11:24:56
    Author     : Oliver
--%>

<%@page import="ServiceLayer.Controller"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ServiceLayer.Entity.Building"%>
<%@page import="DataAccessLayer.DBFacade"%>
<%@page import="ServiceLayer.Entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Bulding</title>
    </head>
    <style>table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
    </style>
    <% Customer c = (Customer) session.getAttribute("LoggedInCustomer");%>
    <body bgcolor="#33CCFF">
        <h1 align='center'>Hello <%= c.getUsername()%></h1>
        <p align='center'>Here you have an overview of your buildings and are able to delete them</p>
        <table style="width: 100%; background: lightblue" >
            <tr>
                <%--This part is writen by Phillip
                The code is to show the customers building and so that they can delete them
                For them to see their buildings they need user_id--%>
                <th>Building ID</th><th>Building Condition</th><th>Building Status</th><th>Building Type</th><th>Building Year</th><th>Size</th><th>Building Name</th><th>Building Adress</th><th>Floor</th><th>Zipcode</th><th>Firm</th><th> </th><th></th><th> </th><th> </th>
            </tr>
            <% Controller con = (Controller) session.getAttribute("Controller");
                ArrayList<Building> buildings = con.getAllCutsomerBuildings(c);
                if (buildings.size() == 0) {%>
            <%= "Du har ingen bygninger endnu"%>
            <%} else if (buildings == null) {%>
            <%="Der er sketen fejl i serveren"%>
            <%} else {
                for (Building building : buildings) {
                    out.println("<tr>");
                    out.println("<td>" + building.getBuilding_id() + "</td>");
                    out.print("<td>" + con.getBuildingCondition(building.getBuilding_id()) + "</td>");
                    out.print("<td>" + building.getBuilding_status() + "</td>");
                    out.print("<td>" + building.getBuilding_type() + "</td>");
                    out.print("<td>" + building.getBuilding_year() + "</td>");
                    out.print("<td>" + con.getTotalSize(building.getBuilding_id()) + "</td>");
                    out.print("<td>" + building.getBuilding_name() + "</td>");
                    out.print("<td>" + building.getBuilding_adress() + "</td>");
                    out.println("<td>" + con.getAllFloors(building.getBuilding_id()) + "</td>");
                    out.println("<td>" + building.getBuilding_zipcode() + "</td>");
                        out.println("<td>" + building.getBuilding_firm() + "</td>");%>
            <%--This is the delete button--%>
            <td> <form action="DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="delete"/>
                    <input type="hidden" name="deletebuilding" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="Delete" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <td> <form action="DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="report"/>
                    <input type="hidden" name="viewreport" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="View reports" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <td> <form action="DeleteBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="request"/>
                    <input type="hidden" name="check-up" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="Request check-up" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <td> <form action="AddBuildingController" method="POST">
                    <input type="hidden" name="do_this" value="viewFloor"/>
                    <input type="hidden" name="floor" value="<%=building.getBuilding_id()%>" />
                    <input type="submit" value="View Floors" width="200%" size="100%" style="width: 100%; font-size: 110%"/>
                </form>
            </td>
            <%out.println("</tr>");
                    }
                }
            %>
        </table>
        <br>
    <td>
        <%--This is to add a building--%>
        <form action="AddBuilding.jsp">
            <input type="submit" value="Add Building" style="width: 10%; height: 5%; font-size: 100%;"/>
        </form>
        <%--This is to return to previous site--%>
    <td> <form action="DeleteBuildingController" method="POST">
            <input  type="submit" name="do_this" value="Return" style="width: 10%; height: 5%; font-size: 100%;"/>
        </form>
    <% if (request.getAttribute("viewFloorError") != null) {%>
    <%= request.getAttribute("viewFloorError")%>
    <%}%>
    </td>
</body>
</html>
