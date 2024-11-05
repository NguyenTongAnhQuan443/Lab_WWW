<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/26/2024
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>LOGIN PAGE</h2>
    <form action="./ControlServlet" method="post">

        <input type="hidden" name="action" value="login">

        <label>ID</label>
        <input type="text" name="id">
        <br>

        <label>PASSWORD</label>
        <input type="text" name="password">
        <br>
        <input type="submit" name="login" value="BTN LOGIN">
    </form>
</body>
</html>
