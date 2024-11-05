package vn.edu.iuh.fit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");

        resp.getWriter().write(userName + "-" + age + "-" + country + "-" + gender + "-");
        resp.getWriter().write("<h3>");
        for(String item : hobbies){
            resp.getWriter().write(item+"+");
        }
        resp.getWriter().write("</h3>");
    }
}
