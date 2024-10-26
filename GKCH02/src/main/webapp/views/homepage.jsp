<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/26/2024
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>HOME PAGE</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <h1>CUA HANG BAN XE GAN MAY ABC</h1>
    <a href="themXe.jsp">Danh sach xe</a> |
    <a href="views/themXe.jsp">Them xe</a>

    <br><br>
    <table>
        <thead>
        <tr>
            <th>Ma xe</th>
            <th>Ten xe</th>
            <th>Gia xe</th>
            <th>Nam sx</th>
            <th>Hang xe</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="xe" items="${LIST_XE}">
            <tr>
                <td>${xe.maXe}</td>
                <td>${xe.tenXe}</td>
                <td>${xe.giaXe}</td>
                <td>${xe.namSanXuat}</td>
                <td>${xe.hangXe.maHangXe}</td>
            </tr>
        </c:forEach>>
        </tbody>
    </table>
</body>
</html>
