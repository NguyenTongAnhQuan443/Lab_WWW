package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Status;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services.RoleServices;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoleController", value = "/RoleController")
public class RoleController extends HttpServlet {
    private static final String PATH_ROLE_MANAGER = "view/roleManager.jsp";

    private RoleServices roleServices;
    @Override
    public void init() throws ServletException {
        roleServices = new RoleServices();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action){
            case "addrole":
                handleAddRole(req, resp);
                break;
            case "deleterole":
                handleDeleteRole(req, resp);
                break;
            case "editrole":
                handleEditRole(req, resp);
                break;
            default:
                break;
        }
    }

    private void handleEditRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);

        String roleId = req.getParameter("roleId");
        String roleName = req.getParameter("roleName");
        String roleDes = req.getParameter("description");
        String roleStatus = req.getParameter("status");
        int status = roleStatus.equals(Status.active) ? 1 : 0;

        Role roleEdit = new Role(roleId, roleName, roleDes, (byte) status);

        boolean result = roleServices.update(roleEdit);

        if(result){
            httpSession.setAttribute("editResult", "success");
        }
        else{
            httpSession.setAttribute("editResult", "failed");
        }
        resp.sendRedirect(req.getContextPath() + "/" + PATH_ROLE_MANAGER);
    }

    private void handleAddRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);

        String roleId = req.getParameter("roleId");
        String roleName = req.getParameter("roleName");
        String des = req.getParameter("description");
        String status = req.getParameter("status");

        Role roleNew = new Role(roleId, roleName, des, (byte)(status.equals(Status.active) ? 1 : 0));
        boolean result = roleServices.add(roleNew);

        if(result){
            httpSession.setAttribute("addResult", "success");
        }else{
            httpSession.setAttribute("addResult", "failed");
        }

        resp.sendRedirect(req.getContextPath() + "/view/roleManager.jsp");
    }


    private void handleDeleteRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);
        String roleId = req.getParameter("roleId");

        boolean result = roleServices.deleteByID(Role.class, roleId);

        if(result){
            httpSession.setAttribute("statusdelete", "success");
        }else {
            httpSession.setAttribute("statusdelete", "failed");
        }
        resp.sendRedirect(req.getContextPath() + "/" + PATH_ROLE_MANAGER);
    }
}
