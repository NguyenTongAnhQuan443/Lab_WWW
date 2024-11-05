<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Create Employee</h2>
    <form action="./StaffServlet" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="userName">UserName</label>
            <input type="text" class="form-control" id="userName" name="fullName" placeholder="Enter UserName">
        </div>
        <div class="form-group">
            <label for="age">Age</label>
            <input type="number" class="form-control" id="age" name="age" value="0">
        </div>
        <div class="form-group">
            <label for="salary">Salary</label>
            <input type="number" class="form-control" id="salary" name="salary" value="0">
        </div>
        <div class="form-group">
            <label for="recruitDate">RecruitDate</label>
            <input type="date" class="form-control" id="recruitDate" name="recruitDate" placeholder="Enter Recruit Date">
        </div>
        <div class="form-group">
            <label for="country">Country</label>
            <select class="form-control" id="country" name="country">
                <option>Viet Nam</option>
                <option>United States</option>
                <option>Canada</option>
                <option>United Kingdom</option>
                <option>Australia</option>
            </select>
        </div>
        <div class="form-group">
            <label>Gender</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="male" value="Male">
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" value="Female">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <div class="form-group">
            <label for="photo">Photo</label>
            <input type="file" class="form-control-file" id="photo" name="image">
        </div>
        <div class="form-group">
            <label>Hobby</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="music" name="hobbies" value="Music">
                <label class="form-check-label" for="music">Music</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="reading" name="hobbies" value="Reading">
                <label class="form-check-label" for="reading">Reading</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="shopping" name="hobbies" value="Shopping">
                <label class="form-check-label" for="shopping">Shopping</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="other" name="hobbies" value="Other">
                <label class="form-check-label" for="other">Other</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="button" class="btn btn-secondary" onclick="window.history.back();">Cancel</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
