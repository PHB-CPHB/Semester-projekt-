<%-- 
    Document   : addFloor
    Created on : 13-04-2016, 22:01:33
    Author     : philliphbrink
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#33CCFF">
    <center>
        <h1>Please enter building infomation</h1>
        <form action="AddBuildingController" method="POST">
            Floor size:<br>
            <input type="text" name="floor_size"><br>
            Apartments:<br>
            <input type="text" name="floor_apartments"><br>
            Rooms:<br>
            <input type="text" name="floor_rooms"><br>
            <input type="hidden" name="do_this" value="addFloor"
            <input type="submit" value="Add Floor">
        </form>
        <br>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </center>
</body>
</html>
