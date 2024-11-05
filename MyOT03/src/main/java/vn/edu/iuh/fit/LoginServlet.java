package vn.edu.iuh.fit;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.models.User;

@WebServlet(urlPatterns = {"/", "/checklogin"})
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("MESSAGE", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login.jsp");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        if (user.checkLogin(userName, password)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/result.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("MESSAGE", "UserName or Password not exit");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    public void destroy() {
    }
}