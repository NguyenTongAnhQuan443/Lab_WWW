<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Thuoc" %>
<html>
<head>
    <title>Danh Sach Thuoc</title>
</head>
<body>
<h1>DANH SACH THUOC</h1>

<table>
    <thead>
    <tr>
        <th>Mã thuốc</th>
        <th>Tên thuốc</th>
        <th>Giá</th>
        <th>Năm SX</th>
        <th>Mã loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<vn.edu.iuh.fit.models.Thuoc> thuocList = (List<vn.edu.iuh.fit.models.Thuoc>) request.getAttribute("LIST_THUOC");
        if (thuocList != null) {
            for (vn.edu.iuh.fit.models.Thuoc thuoc : thuocList) {
    %>
    <tr>
        <td><%= thuoc.getMaThuoc() %>
        </td>
        <td><%= thuoc.getTenThuoc() %>
        </td>
        <td><%= thuoc.getGia() %>
        </td>
        <td><%= thuoc.getNamSX() %>
        </td>
        <td><%= thuoc.getLoaiThuoc().getMaLoai() %>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">Không có dữ liệu</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
