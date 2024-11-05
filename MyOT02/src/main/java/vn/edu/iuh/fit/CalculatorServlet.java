package vn.edu.iuh.fit;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/calculator.jsp");
        requestDispatcher.forward(request, response);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        double numberA = Double.parseDouble(request.getParameter("numberA"));
//        double numberB = Double.parseDouble(request.getParameter("numberB"));
//
//        String action = request.getParameter("action");
//        double result = numberA + numberB;
//
//        request.setAttribute("RESULT", result);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/result.jsp");
//        requestDispatcher.forward(request, response);
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double numberA = Double.parseDouble(req.getParameter("numberA"));
        double numberB = Double.parseDouble(req.getParameter("numberB"));

        String action = req.getParameter("action");
        double result = 0;
        switch (action){
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "x":
                result = numberA * numberB;
                break;
            case "/":
                result = numberA / numberB;
            default:
                result = 0;
                break;
        }

        req.setAttribute("NUMBERA", numberA);
        req.setAttribute("NUMBERB", numberB);
        req.setAttribute("ACTION", action);
        req.setAttribute("RESULT", result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/result.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void destroy() {
    }
}