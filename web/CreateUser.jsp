<%-- 
    Document   : CreateCustomer
    Created on : 31-03-2016, 11:07:34
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create user</h1>
        <form action="AdminServlet" method="POST">
        Username <br>
        <input type="text" name="username"><br>
        Password <br>
        <input type="text" name="password"><br>
        Firm <br>
        <input type="text" name="user_firm"><br>
        <select name="role">
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
        </select>
        <input type="hidden" name="do_this" value="createUser"/>
            <input type="submit" value="Create User" />
        </form>
    </body>
</html>
