<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String successMessage = request.getParameter("success");
    String errorMessage = request.getParameter("error");
%>

<% if (successMessage != null && successMessage.equals("updateSuccess")) { %>
<div class="alert alert-success" role="alert">
    Thay đổi mật khẩu thành công!
</div>
<% } %>

<% if (errorMessage != null && (errorMessage.equals("invalidPassword") || errorMessage.equals("updateFailed"))) { %>
<div class="alert alert-danger" role="alert">
    Thay đổi mật khẩu thất bại. Vui lòng thử lại.
</div>
<% } %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Change</title>

    <!-- Bootstrap CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <!-- Custom CSS -->
    <style>
        .pass_show {
            position: relative;
        }

        .pass_show .ptxt {
            position: absolute;
            top: 50%;
            right: 10px;
            z-index: 1;
            color: #f36c01;
            margin-top: -10px;
            cursor: pointer;
            transition: .3s ease all;
        }

        .pass_show .ptxt:hover {
            color: #333333;
        }

        .btn-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-4">

            <form action="${pageContext.request.contextPath}/AccountController?action=changepassword"
                  method="post" id="changepassword">
                <label>Current Password</label>
                <div class="form-group pass_show">
                    <input type="password" class="form-control" id="currentPassword" name="currentPassword"
                           placeholder="Current Password">
                </div>
                <label>New Password</label>
                <div class="form-group pass_show">
                    <input type="password" class="form-control" id="newPassword" name="newPassword"
                           placeholder="New Password">
                </div>
                <label>Confirm Password</label>
                <div class="form-group pass_show">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           placeholder="Confirm Password">
                </div>

                <!-- Button Container -->
                <div class="btn-container">

                    <!-- Save Button -->
                    <button type="submit" class="btn btn-success">Save</button>

                    <!-- Back Button -->
                    <button type="button" class="btn btn-secondary" onclick="goBack()">Quay lại</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- jQuery and Bootstrap JS -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script>
    $(document).ready(function () {
        $('.pass_show').append('<span class="ptxt">Show</span>');
    });

    $(document).on('click', '.pass_show .ptxt', function () {
        $(this).text($(this).text() == "Show" ? "Hide" : "Show");
        $(this).prev().attr('type', function (index, attr) {
            return attr == 'password' ? 'text' : 'password';
        });
    });

    // Go back function
    function goBack() {
        window.history.back(); // This will go to the previous page
    }
</script>

</body>
</html>
