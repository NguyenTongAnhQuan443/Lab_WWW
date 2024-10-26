package vn.edu.iuh.fit.Controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.models.LoaiThuoc;
import vn.edu.iuh.fit.models.Thuoc;
import vn.edu.iuh.fit.services.QuanLyLoaiThuocServices;
import vn.edu.iuh.fit.services.QuanLyThuocServices;

@WebServlet("/QuanLyThuocServlet")
public class QuanLyThuocServlet extends HttpServlet {
    private QuanLyThuocServices quanLyThuocServices = new QuanLyThuocServices();
    private QuanLyLoaiThuocServices quanLyLoaiThuocServices = new QuanLyLoaiThuocServices();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String view = "/views/homepage.jsp";

        if (action != null) {
            switch (action) {
                case "xuatDanhSachThuoc":
                    List<Thuoc> listThuoc = quanLyThuocServices.getAll();
                    request.setAttribute("LIST_THUOC", listThuoc);
                    view = "/views/danhSachThuoc.jsp";
                    break;

                case "xuatDanhSachLoaiThuoc":
                    List<LoaiThuoc> listLoaiThuoc = quanLyLoaiThuocServices.getAll();
                    request.setAttribute("LIST_LOAI_THUOC", listLoaiThuoc);
                    view = "/views/danhSachLoaiThuoc.jsp";
                    break;

                case "themThuocMoi":
                    view = "/views/themThuocMoi.jsp";
                    break;

                default:
                    break;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý nếu cần cho POST request
    }

    public void destroy() {
    }
}
