<%-- 
    Document   : Login
    Created on : Mar 30, 2016, 11:06:48 AM
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
        <h1>Please enter your login</h1>
        <form action="loginctrl" method="POST">
            Username:<br>
            <input type="text" name="username"><br>
            Password:<br>
            <input type="text" name="password"><br>
            <input type="submit" value="login" name="dothis">
        </form>
    </body>
</html>
