<%-- 
    Document   : Report
    Created on : Apr 7, 2016, 11:50:52 AM
    Author     : Thesoap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="AddBuildingController" method="POST">
            <input type="hidden" value="return" name="do_this">
            <input type="submit" value="Return" style="width: 30%; height: 30%; font-size: 100%;"/>
        </form>
    </body>
</html>
