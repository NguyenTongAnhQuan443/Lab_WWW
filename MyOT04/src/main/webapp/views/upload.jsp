<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Upload Photo</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h2>Upload Photo</h2>
  <form action="./UploadPhotoServlet" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="id" name="id" placeholder="Enter id">
    </div>
    <div class="form-group">
      <label for="fullName">Full Name</label>
      <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Enter name">
    </div>
    <div class="form-group">
      <label for="photo">Photo</label>
      <input type="file" class="form-control-file" id="photo" name="photo">
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
    <button type="button" class="btn btn-secondary" onclick="window.history.back();">Cancel</button>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
