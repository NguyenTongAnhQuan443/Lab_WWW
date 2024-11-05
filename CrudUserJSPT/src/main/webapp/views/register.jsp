<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dang Ky</title>
  <style>
    .form-container {
      width: 300px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 10px;
      background-color: #f9f9f9;
    }
    .form-container input[type="text"],
    .form-container input[type="password"],
    .form-container input[type="number"],
    .form-container input[type="date"] {
      width: 100%;
      padding: 8px;
      margin: 8px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .form-container input[type="radio"] {
      margin: 0 5px;
    }
    .form-container button {
      margin: 5px;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      background-color: #007bff;
      color: white;
      cursor: pointer;
    }
    .form-container button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="form-container">
  <h2>Dang Ky</h2>
  <form action="registerUser" method="post">
    <label for="username">UserName</label>
    <input type="text" id="username" name="userName" placeholder="Enter UserName" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="Enter password" required>

    <label for="fullname">FullName</label>
    <input type="text" id="fullname" name="fullName" placeholder="Enter fullname" required>

    <label for="age">Age</label>
    <input type="number" id="age" name="age" value="0" min="0" required>

    <label for="birthday">Birthday</label>
    <input type="date" id="birthday" name="birthday" required>

    <label>Gender</label>
    <input type="radio" id="male" name="gender" value="Male" checked>
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="Female">
    <label for="female">Female</label>

    <br><br>
    <button type="submit">Submit</button>
    <button type="reset">Cancel</button>
    <button type="button" onclick="window.location.href='displayUsers.jsp'">Display Users</button>
  </form>
</div>
</body>
</html>
