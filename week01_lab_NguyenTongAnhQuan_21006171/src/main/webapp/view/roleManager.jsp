<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role" %>
<%@ page import="vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services.RoleServices" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String messAdd = (String) session.getAttribute("addResult");
    if (messAdd != null && messAdd.equals("failed")) {
%>
<div class="alert alert-danger" role="alert">
    Thêm thất bại !
</div>
<%
    }
    RoleServices roleServices;
    roleServices = new RoleServices();
    List<Role> roleList = roleServices.findAll(Role.class);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Role Manager</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f7f7f7;
        }

        .container {
            margin-top: 50px;
            max-width: 900px;
        }

        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .card-header {
            background-color: #007bff;
            color: white;
            font-size: 1.5rem;
            font-weight: bold;
            text-align: center;
            padding: 15px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        table thead {
            background-color: #007bff;
            color: white;
        }

        .btn-primary, .btn-danger, .btn-warning {
            width: 40px;
            height: 40px;
            padding: 5px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header">
            Role Manager
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Role ID</th>
                    <th scope="col">Role Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Status</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for(Role role : roleList) { %>
                <tr>
                    <td><%= role.getRoleId() %></td>
                    <td><%= role.getRoleName() %></td>
                    <td><%= role.getDescription() %></td>
                    <td><%= role.getStatus() %></td>
                    <td>
                        <!-- Edit Icon -->
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editRoleModal<%= role.getRoleId() %>">
                            <i class="fas fa-edit">Edit</i>
                        </button>

                        <!-- Delete Icon -->
                        <form action="${pageContext.request.contextPath}/RoleController?action=deleterole" method="post" style="display:inline;">
                            <input type="hidden" name="roleId" value="<%= role.getRoleId() %>">
                            <button type="submit" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Delete Role">
                                <i class="fas fa-trash-alt">Delete</i>
                            </button>
                        </form>
                    </td>
                </tr>

                <!-- Edit Role Modal -->
                <div class="modal fade" id="editRoleModal<%= role.getRoleId() %>" tabindex="-1" role="dialog" aria-labelledby="editRoleModalLabel<%= role.getRoleId() %>" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="editRoleModalLabel<%= role.getRoleId() %>">Edit Role: <%= role.getRoleName() %></h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="${pageContext.request.contextPath}/RoleController?action=editrole" method="post">
                                    <input type="hidden" name="roleId" value="<%= role.getRoleId() %>">
                                    <div class="form-group">
                                        <label for="roleName">Role Name</label>
                                        <input type="text" class="form-control" id="roleName1" name="roleName" value="<%= role.getRoleName() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <textarea class="form-control" id="description1" name="description" rows="3" required><%= role.getDescription() %></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="status">Status</label>
                                        <select class="form-control" id="status1" name="status" required>
                                            <option value="active" <%= role.getStatus().equals("active") ? "selected" : "" %>>active</option>
                                            <option value="inactive" <%= role.getStatus().equals("inactive") ? "selected" : "" %>>inactive</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Edit Role Modal -->

                <% } %>
                </tbody>
            </table>

            <!-- Button to add new role -->
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addRoleModal">
                Add New Role
            </button>
        </div>
    </div>
</div>

<!-- Add Role Modal -->
<div class="modal fade" id="addRoleModal" tabindex="-1" role="dialog" aria-labelledby="addRoleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addRoleModalLabel">Add New Role</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/RoleController?action=addrole" method="post">
                    <div class="form-group">
                        <label for="roleId">Role ID</label>
                        <input type="text" class="form-control" id="roleId" name="roleId" required>
                    </div>
                    <div class="form-group">
                        <label for="roleName">Role Name</label>
                        <input type="text" class="form-control" id="roleName" name="roleName" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <select class="form-control" id="status" name="status" required>
                            <option value="active">Active</option>
                            <option value="inactive">Inactive</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Optional: Font Awesome for icons -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

</body>
</html>
