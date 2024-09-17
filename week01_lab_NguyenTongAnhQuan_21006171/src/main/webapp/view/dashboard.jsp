<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) session.getAttribute("account");
    String path = request.getContextPath();
    if (account == null) {
        response.sendRedirect(path + "/index.jsp");
        return;
    }

    List<Account> accountList = session.getAttribute("listAccount") != null ? (List<Account>) session.getAttribute("listAccount") : null;
%>
<html>
<head>
    <title>Dashboard</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body {
            background-image: url(https://static.pexels.com/photos/371633/pexels-photo-371633.jpeg);
            background-repeat: no-repeat;
            background-size: 100%;
        }

        footer {
            margin-top: 20px;
            padding-top: 20px;
        }

        .bg__card__navbar {
            background-color: #000000;
        }

        .bg__card__footer {
            background-color: #000000 !important;
        }

        #add__new__list {
            top: -38px;
            right: 0px;
        }
    </style>
    <script>
        // Hàm để chuyển các ô trong bảng thành input để chỉnh sửa
        function enableEdit(rowId) {
            var row = document.getElementById("row_" + rowId);
            row.querySelectorAll(".view-mode").forEach(function (el) {
                el.style.display = "none";
            });
            row.querySelectorAll(".edit-mode").forEach(function (el) {
                el.style.display = "block";
            });
            row.querySelector(".edit-button").style.display = "none";
            row.querySelector(".save-button").style.display = "inline-block";
            row.querySelector(".cancel-button").style.display = "inline-block";
        }

        // Hàm để hủy chỉnh sửa và quay lại chế độ xem
        function cancelEdit(rowId) {
            var row = document.getElementById("row_" + rowId);
            row.querySelectorAll(".view-mode").forEach(function (el) {
                el.style.display = "block";
            });
            row.querySelectorAll(".edit-mode").forEach(function (el) {
                el.style.display = "none";
            });
            row.querySelector(".edit-button").style.display = "inline-block";
            row.querySelector(".save-button").style.display = "none";
            row.querySelector(".cancel-button").style.display = "none";
        }
    </script>
</head>
<body>
<header>
    <div class="container bg-info p-5 ">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">


            <a class="navbar-brand" href="#">WWW-WEEK-01</a>


            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">


                    <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/view/addAccount.jsp">Add Account <span
                            class="sr-only">(current)</span></a>

                    <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/view/roleManager.jsp">Role Manager<span
                            class="sr-only">(current)</span></a>

                </div>
                <div class="navbar-nav ml-auto">
                    <h4><%=account.getFullName().toString()%>
                    </h4>
                </div>
                <!-- Nút Log out nằm ở bên phải -->
                <div class="navbar-nav ml-auto">
                    <form action="${pageContext.request.contextPath}/AccountController?action=logout" method="post">
                        <button type="submit" class="btn btn-outline-danger">Log out</button>
                    </form>
                </div>

                <div class="navbar-nav ml-auto">
                    <form action="${pageContext.request.contextPath}/view/changePassword.jsp">
                        <button type="submit" class="btn btn-outline-danger">Change Password</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</header>

<main>
    <div class="container my-5">
        <div class="card-body text-center">
            <h4 class="card-title">Account Manager</h4>
        </div>
        <div class="card">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">AccountId</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Status</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Account a : accountList) { %>
                <tr id="row_<%= a.getAccountId() %>">
                    <form action="${pageContext.request.contextPath}/AccountController?action=update" method="post">
                        <td>
                            <%= a.getAccountId() %>
                            <input type="hidden" name="accountId" value="<%= a.getAccountId() %>">
                        </td>
                        <td>
                            <span class="view-mode"><%= a.getFullName() %></span>
                            <input type="text" class="form-control edit-mode" name="fullName"
                                   value="<%= a.getFullName() %>" style="display: none;">
                        </td>
                        <td>
                            <span class="view-mode"><%= a.getEmail() %></span>
                            <input type="email" class="form-control edit-mode" name="email" value="<%= a.getEmail() %>"
                                   style="display: none;">
                        </td>
                        <td>
                            <span class="view-mode"><%= a.getPhone() %></span>
                            <input type="text" class="form-control edit-mode" name="phone" value="<%= a.getPhone() %>"
                                   style="display: none;">
                        </td>
                        <td>
                            <span class="view-mode"><%= a.getStatus() %></span>
                            <input type="text" class="form-control edit-mode" name="password"
                                   value="<%= a.getPassword() %>" style="display: none;">
                            <input type="text" class="form-control edit-mode" name="status" value="<%= a.getStatus() %>"
                                   style="display: none;">
                        </td>
                        <td>
                            <!-- Nút Edit để chuyển sang chế độ chỉnh sửa -->
                            <button type="button" class="btn btn-sm btn-primary edit-button"
                                    onclick="enableEdit('<%= a.getAccountId() %>')">
                                <i class="far fa-edit"></i> Edit
                            </button>
                            <!-- Nút Save và Cancel xuất hiện khi ở chế độ chỉnh sửa -->
                            <%
                                session.setAttribute("context", "dashboardContext");
                            %>
                            <button type="submit" class="btn btn-sm btn-success save-button" style="display:none;"><i
                                    class="fas fa-save"></i> Save
                            </button>
                            <button type="button" class="btn btn-sm btn-secondary cancel-button" style="display:none;"
                                    onclick="cancelEdit('<%= a.getAccountId() %>')"><i class="fas fa-times"></i> Cancel
                            </button>
                        </td>
                    </form>
                    <td>
                        <!-- Nút Delete để xóa tài khoản -->
                        <form action="${pageContext.request.contextPath}/AccountController?action=deleteaccount"
                              method="post" style="display:inline;">
                            <input type="hidden" name="accountId" value="<%= a.getAccountId() %>">
                            <button type="submit" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Delete
                            </button>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</main>

<footer>
    <div class="container bg-info p-5">
    </div>
</footer>
</body>
</html>
