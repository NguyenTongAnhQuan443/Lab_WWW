package vn.edu.iuh.fit;

import java.io.*;
import java.text.ParseException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.dao.UserDAO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserDAO userDAO = new UserDAO();
        try {
            request.setAttribute("LIST_USER", userDAO.dumyData());
        } catch (Exception e) {

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/display-user.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}