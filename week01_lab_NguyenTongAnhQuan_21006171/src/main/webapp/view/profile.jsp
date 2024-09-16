<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) session.getAttribute("account");

%>
<%
    String successMessage = request.getParameter("success");
    String errorMessage = request.getParameter("error");
%>

<%
    if (successMessage != null) {
%>
<div class="alert alert-success" role="alert">
    Cập nhật thành công!
</div>
<%
    }
%>

<%
    if (errorMessage != null) {
%>
<div class="alert alert-danger" role="alert">
    Cập nhật thất bại. Vui lòng thử lại.
</div>
<%
    }
%>

<html>
<head>
    <title>Profile</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body {
            margin-top: 20px;
            color: #1a202c;
            text-align: left;
            background-color: #e2e8f0;
        }

        .main-body {
            padding: 15px;
        }

        .card {
            box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0 rgba(0, 0, 0, .06);
        }

        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0, 0, 0, .125);
            border-radius: .25rem;
        }

        .card-body {
            flex: 1 1 auto;
            min-height: 1px;
            padding: 1rem;
        }

        .gutters-sm {
            margin-right: -8px;
            margin-left: -8px;
        }

        .gutters-sm > .col, .gutters-sm > [class*=col-] {
            padding-right: 8px;
            padding-left: 8px;
        }

        .mb-3, .my-3 {
            margin-bottom: 1rem !important;
        }

        .bg-gray-300 {
            background-color: #e2e8f0;
        }

        .h-100 {
            height: 100% !important;
        }

        .shadow-none {
            box-shadow: none !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="main-body">

        <!-- Breadcrumb -->
        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
                <li class="breadcrumb-item active" aria-current="page">User Profile</li>
            </ol>
        </nav>
        <!-- /Breadcrumb -->

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin"
                                 class="rounded-circle" width="150">
                            <div class="mt-3">
                                <h4>John Doe</h4>
                                <p class="text-secondary mb-1">Full Stack Developer</p>
                                <p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>
                                <form action="${pageContext.request.contextPath}/AccountController?action=logout"
                                      method="post">
                                    <button type="submit" class="btn btn-outline-primary">Logout</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Account ID</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= account.getAccountId() %>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <span id="fullNameDisplay"><%= account.getFullName() %></span>
                                <input type="text" id="fullNameEdit" value="<%= account.getFullName() %>"
                                       class="form-control" style="display: none;">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <span id="emailDisplay"><%= account.getEmail() %></span>
                                <input type="email" id="emailEdit" value="<%= account.getEmail() %>"
                                       class="form-control"
                                       style="display: none;">
                            </div>

                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <span id="phoneDisplay"><%= account.getPhone() %></span>
                                <input type="text" id="phoneEdit" value="<%= account.getPhone() %>" class="form-control"
                                       style="display: none;">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-12">
                                <button class="btn btn-info" id="editButton" onclick="enableEdit()">Edit</button>

                                <button class="btn btn-info" id="changePassword" onclick="window.location.href='${pageContext.request.contextPath}/view/changePassword.jsp'; return false;">Change Password</button>


                                <!-- Hidden Form for Submitting Data -->
                                <form action="${pageContext.request.contextPath}/AccountController?action=update"
                                      method="post" id="editForm">
                                    <input type="hidden" name="accountId" value="<%= account.getAccountId() %>">
                                    <input type="hidden" name="fullName" id="fullNameInput">
                                    <input type="hidden" name="password" value="<%=account.getPassword()%>">
                                    <input type="hidden" name="email" id="emailInput">
                                    <input type="hidden" name="phone" id="phoneInput">
                                    <input type="hidden" name="status" value="<%= account.getStatus() %>">
                                    <button class="btn btn-success" id="saveButton" onclick="saveChanges()"
                                            style="display: none;">Save
                                    </button>
                                </form>
                                <button class="btn btn-secondary" id="cancelButton" onclick="cancelEdit()"
                                        style="display: none;">Cancel
                                </button>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<script>
    function enableEdit() {
        // Show input fields and hide display spans
        document.getElementById("fullNameDisplay").style.display = "none";
        document.getElementById("emailDisplay").style.display = "none";
        document.getElementById("phoneDisplay").style.display = "none";

        document.getElementById("fullNameEdit").style.display = "block";
        document.getElementById("emailEdit").style.display = "block";
        document.getElementById("phoneEdit").style.display = "block";

        // Show Save and Cancel buttons, hide Edit button
        document.getElementById("editButton").style.display = "none";
        document.getElementById("saveButton").style.display = "inline-block";
        document.getElementById("cancelButton").style.display = "inline-block";
    }

    function saveChanges() {
        // Get the values from input fields
        var fullName = document.getElementById("fullNameEdit").value;
        var email = document.getElementById("emailEdit").value;
        var phone = document.getElementById("phoneEdit").value;

        // Update hidden form fields
        document.getElementById("fullNameInput").value = fullName;
        document.getElementById("emailInput").value = email;
        document.getElementById("phoneInput").value = phone;

        // Submit the form
        document.getElementById("editForm").submit();
    }

    function cancelEdit() {
        // Hide input fields and show display spans
        document.getElementById("fullNameDisplay").style.display = "block";
        document.getElementById("emailDisplay").style.display = "block";
        document.getElementById("phoneDisplay").style.display = "block";

        document.getElementById("fullNameEdit").style.display = "none";
        document.getElementById("emailEdit").style.display = "none";
        document.getElementById("phoneEdit").style.display = "none";

        // Hide Save and Cancel buttons, show Edit button
        document.getElementById("editButton").style.display = "inline-block";
        document.getElementById("saveButton").style.display = "none";
        document.getElementById("cancelButton").style.display = "none";
    }
</script>

</body>
</html>
