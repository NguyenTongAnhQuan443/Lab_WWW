<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/24/2024
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATOR</title>
</head>
<body>
    <h1>CALCULATOR</h1>
    <hr>
    <form action="<%= request.getContextPath()%>/CalculatorServlet" method="post">
        <p> <input type="text" name="numberA"> </p>
        <p> <input type="text" name="numberB"> </p>
        <p>
            <input type="submit" name="action" value="+">
            <input type="submit" name="action" value="-">
            <input type="submit" name="action" value="x">
            <input type="submit" name="action" value="/">
        </p>
    </form>
</body>
</html>
