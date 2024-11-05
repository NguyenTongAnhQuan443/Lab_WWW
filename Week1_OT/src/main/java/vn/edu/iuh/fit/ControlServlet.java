package vn.edu.iuh.fit;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.Services.AccountServices;
import vn.edu.iuh.fit.models.Account;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {

    private AccountServices accountServices = new AccountServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        switch (action) {
            case "login":
                String id = req.getParameter("id");
                String pass = req.getParameter("password");
                resp.getWriter().write(id + "-" + pass);
                Account account = accountServices.checkLogin(id, pass);
                if (account != null) {
                    resp.getWriter().write(account.getFullName());
                    resp.getWriter().write(account.getPhone());
                }
        }
    }
}