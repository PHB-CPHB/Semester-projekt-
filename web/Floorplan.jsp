<%-- 
    Document   : Floorplan
    Created on : 11-04-2016, 12:18:57
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
        <h1>You have not yet uploaded any floorplan for this building. Do you want to upload it now?</h1>
        <form action="ImageController" method="POST" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit">
        </form>
    </body>
</html>
