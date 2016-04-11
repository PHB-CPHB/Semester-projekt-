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
        <title>Login Page</title>
    </head>
    <body bgcolor="#33CCFF">
    <center><h1>Please enter your login</h1></center>
    <form action="LoginController" method="POST">
        <center>Username:<br></center>
        <center><input type="text" name="username" style="width: 20%; height: 40%;"><br></center>
        <center>Password:<br></center>
        <center><input type="password" name="password" style="width: 20%; height: 40%;"><br></center>
        <center><input type="submit" value="Login" style="width: 30%; height: 120%; font-size: 120%;"></center>
    </form>
</body>
</html>
