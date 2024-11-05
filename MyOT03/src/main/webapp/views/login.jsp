<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>JSP Page</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
  <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
    <div class="col-sm-12">
      <h2>Login</h2>
      <form action="./checklogin" method="post">
        <input type="hidden" class="form-control" name="action" value="" >
        <div class="form-group">
          <label>UserName:</label>
          <input type="text" class="form-control" name="username" value=""  placeholder="Enter UserName">
        </div>

        <div class="form-group">
          <label>Password:</label>
          <input type="password" class="form-control" name="password" value="" placeholder="Enter age">
        </div>


        <div class="form-group">
          <div class="radio">
            <label class="checkbox-inline"><input type="checkbox" name="remember" >Remember me</label>

          </div>
        </div>
        <p style="color: red;">${MESSAGE}</p>
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="reset" class="btn btn-primary">Cancel</button>
        <p style="margin: 10px; font-size: 10px;"><a href="#">Register</a></p>
      </form>
    </div>
  </div>
</div>
</body>
</html>
