<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/21/2024
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddProduct</title>
</head>
<body>
    <form action="Controller" method="get">
        <input type="hidden" name="action" value="add"> </br>
        <input name="name"/></br>
        <input name="desc"/></br>
        <input name="img"/></br>

        <input type="submit" value="Insert">
        <input type="reset"/>
    </form>
</body>
</html>
