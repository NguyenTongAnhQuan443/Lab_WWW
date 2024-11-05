package vn.edu.iuh.fit;

import java.io.*;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import vn.edu.iuh.fit.models.Staff;

@MultipartConfig
@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/staff.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("đ/MM/yyyy");
            ConvertUtils.register(dateTimeConverter, Date.class);

            Staff staff = new Staff();
            BeanUtils.populate(staff, req.getParameterMap());

            req.setAttribute("STAFF", staff);
            resp.getWriter().write("<h2>" + staff.toString() + "</h2>");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}