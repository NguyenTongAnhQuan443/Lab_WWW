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
      <h2>Register</h2>
      <form action="./RegisterServlet" method="post">
        <input type="hidden" class="form-control" name="action" value="" >
        <div class="form-group">
          <label>UserName</label>
          <input type="text" class="form-control" name="username" value=""  placeholder="Enter UserName">
        </div>

        <div class="form-group">
          <label>Age</label>
          <input type="number" class="form-control" name="age" value="" placeholder="Enter age">
        </div>

        <div class="form-group">
          <label>Country</label>
          <select class="form-control" name="country">
            <option value="Viet Nam">Viet Nam</option>
            <option value="My">My</option>
            <option value="Nhat Ban">Nhat Ban</option>
            <option value="Anh">Anh</option>
          </select>
        </div>
        <div class="form-group">
          <label>Gender</label>
          <div class="radio"><!--value = 1 => Nam| 0 =>Nu -->
            <label class="checkbox-inline"><input type="radio" name="gender"  value="1" >Male</label>
            <label class="checkbox-inline"><input type="radio" name="gender"  value="0" checked> Female</label>

          </div>
        </div>
        <div class="form-group">
          <label>Hobby</label>
          <div class="checkbox">
            <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Music" >Music</label>
            <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Reading" checked>Reading</label>
            <label class="checkbox-inline"><input type="checkbox" name="hobbies"  value="Shopping" checked>Shopping</label>

          </div>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="reset" class="btn btn-primary">Cancel</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
