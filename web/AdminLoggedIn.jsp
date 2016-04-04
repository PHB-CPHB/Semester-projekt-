<%-- 
    Document   : AdminLoggedIn
    Created on : 31-03-2016, 10:45:27
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
        <h1>Hello admin <%= session.getAttribute("username")%>.</h1>
        <form action="AdminLoggedInController">
            <input type="submit" name="dothis" value="Create user">
        </form>
        <br>
            <form action="AdminLoggedInController">
                <input type="submit" name="dothis" value="View user">
            </form>
        
                    </body>
                    </html>
