<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/26/2024
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them xe</title>
</head>
<body>
<h1>Form Them xe</h1>
<form action="../ControllerServlet" method="post">
    <input type="hidden" name="action" value="themXe"><br>
    <label>ma xe</label><br>
    <input type="text" name="maXe"><br>

    <label>ten xe</label><br>
    <input type="text" name="tenXe"><br>

    <label>gia xe</label><br>
    <input type="text" name="giaXe"><br>

    <label>nam san xuat</label><br>
    <input type="text" name="namSanXuat"><br>

    <label>hang xe</label><br>
    <input type="text" name="hangXe"><br>

    <input type="submit" value="Them xe"><br>
</form>
</body>
</html>
