package vn.edu.iuh.fit.Controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import vn.edu.iuh.fit.models.HangXe;
import vn.edu.iuh.fit.models.Xe;
import vn.edu.iuh.fit.services.HangXeServices;
import vn.edu.iuh.fit.services.XeServices;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private XeServices xeServices = new XeServices();
    private HangXeServices hangXeServices = new HangXeServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
        String view = "/views/homepage.jsp";

//        switch (action){
//            case "":
//                break;
//        }
        List<Xe> listXe = xeServices.getAll();
        resp.getWriter().write(listXe +"ne");
        req.setAttribute("LIST_XE", listXe);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "themXe":
                String maXe = req.getParameter("maXe");
                String hangXeText = req.getParameter("hangXe");

                HangXe hangXe = new HangXe();
                hangXe.setMaHangXe(hangXeText);

                Xe xe = new Xe();
                xe.setMaXe(maXe);
                //

                xeServices.add(xe);
                break;
        }
    }
}