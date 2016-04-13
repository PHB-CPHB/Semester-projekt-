<%-- 
    Document   : AddBuilding
    Created on : Mar 30, 2016, 11:14:38 AM
    Author     : Thesoap
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
            Name of building:<br>
            <input type="text" name="name"><br>
            Address:<br>
            <input type="text" name="address"><br>
            Zipcode:<br>
            <input type="text" name="zipcode"><br>
            Parcel no.:<br>
            <input type="text" name="parcel"><br>
            Size of building(m^2):<br>
            <input type="text" name="size"><br>
            Building type:<br>
            <input type="text" name="type"><br>      
            Building year:<br>
            <input type="text" name="year"><br>
            <input type="submit" value="add" name="do_this">
        </form>
        <br>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </center>
</body>
</html>
