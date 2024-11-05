<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.User" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Users</title>
    <style>
        .table-container {
            width: 80%;
            margin: 20px auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-add {
            background-color: #007bff;
            color: white;
            margin-bottom: 10px;
        }
        .btn-edit {
            background-color: #28a745;
            color: white;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
        }
    </style>
</head>
<body>
<div class="table-container">
    <h2>List Users</h2>
    <button class="btn btn-add" onclick="window.location.href='addUser.jsp'">Add Users</button>
    <table>
        <thead>
        <tr>
            <th>UserName</th>
            <th>Password</th>
            <th>FullName</th>
            <th>Age</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%-- Ví dụ dữ liệu tĩnh, thay bằng mã động để lấy từ cơ sở dữ liệu --%>
        <c:forEach var="user" items="${LIST_USER}">
            <tr>
                    <%--copy thuoc tinh ben entity bo vao --%>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.fullName}</td>
                <td>${user.age}</td>
                <td><fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy"/></td>
                <td>${user.gender ? "Name" : "Nữ"}</td>
                <td>
                    <button class="btn btn-edit" onclick="window.location.href='editUser.jsp?username=a3'">Edit</button>
                    <button class="btn btn-delete" onclick="deleteUser('a3')">Del</button>
                </td>
            </tr>
        </c:forEach>
        <%-- Thêm các hàng khác theo dữ liệu thực tế --%>
        </tbody>
    </table>
</div>

<script>
    function deleteUser(username) {
        if (confirm("Are you sure you want to delete user " + username + "?")) {
            window.location.href = "deleteUser?username=" + username;
        }
    }
</script>
</body>
</html>
