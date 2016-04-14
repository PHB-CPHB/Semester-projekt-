<%-- 
    Document   : editFloor
    Created on : 14-04-2016, 19:31:44
    Author     : philliphbrink
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Floor</title>
    </head>
    <body bgcolor="#33CCFF">
    <center>
        <h1>Please enter the chanced information</h1>
        <form action="AddBuildingController" method="POST">
            Floor size:<br>
            <input type="text" name="floor_si" value="<%= request.getAttribute("floor_si")%>"><br>
            Apartments:<br>
            <input type="text" name="floor_apt" value="<%= request.getAttribute("floor_apt")%>"><br>
            Rooms:<br>
            <input type="text" name="floor_ro" value="<%= request.getAttribute("floor_ro")%>"><br>
            <input type="hidden" name="floor_n" value="<%= request.getAttribute("floor_n")%>">
            <input type="hidden" name="floor_b_id" value="<%= request.getAttribute("floor_b_id")%>">
            <input type="hidden" name="do_this" value="edit">
            <input type="submit" value="Edit" style="width: 30%; height: 30%; font-size: 100%;">
        </form>
        <br>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="returnFloor" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </center>
</body>
</html>
