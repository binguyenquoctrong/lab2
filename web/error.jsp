<%-- 
    Document   : error
    Created on : Dec 16, 2020, 11:26:54 AM
    Author     : Quoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <h2>
            <font color="red">
            ${requestScope.ERROR}
            </font>
        </h2>
        <br/>
        <form action="logout" method="POST">
            <button type="submit" name="btnAction" value="Logout"> Back To Index Page</button>
        </form>
    </body>
</html>
