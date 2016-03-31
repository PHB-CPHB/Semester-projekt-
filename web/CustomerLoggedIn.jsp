<%-- 
    Document   : CustomerLoggedIn
    Created on : 31-03-2016, 10:47:00
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
        <h1>Hello customer <%= session.getAttribute("LI") %>.</h1>
    </body>
</html>
