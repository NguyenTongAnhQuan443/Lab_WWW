package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.beans.Utils;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Log;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services.AccountServices;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services.GrantAccessServices;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services.LogServices;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AccountController", value = "/AccountController")
public class AccountController extends HttpServlet {
    private static final String PATH_VIEW_LOGIN = "index.jsp";
    private static final String PATH_VIEW_PROFILE = "view/profile.jsp";
    private static final String PATH_VIEW_DASHBOARD = "view/dashboard.jsp";
    private static final String PATH_VIEW_CHANGE_PASSWORD = "view/changePassword.jsp";

    private static String ROLE_ADMIN = "admin";
    private static String ROLE_USER = "user";


    private AccountServices accountServices;
    private Utils utils;
    private LogServices logServices;
    private GrantAccessServices grantAccessServices;

    @Override
    public void init() throws ServletException {
        accountServices = new AccountServices();
        utils = new Utils();
        logServices = new LogServices();
        grantAccessServices = new GrantAccessServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "login":
                handleLogin(req, resp);
                break;
            case "logout":
                handleLogout(req, resp);
                break;
            case "update":
                handleUpdate(req, resp);
                break;
            case "changepassword":
                handleChangePassword(req, resp);
                break;
            default:
                break;
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = accountServices.isLogin(username, password);

        if (account == null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("message", "Invalid username or password");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            resp.sendRedirect(PATH_VIEW_LOGIN);
        } else {
            Log log = new Log(
                    account.getAccountId(),
                    utils.convertLocalDateTimeToInstant(LocalDateTime.now()),
                    utils.convertLocalDateTimeToInstant(LocalDateTime.now()),
                    "User Login");

            boolean isAdmin = grantAccessServices.findByAccountId(account.getAccountId())
                    .getRole()
                    .getRoleId()
                    .toString().equals(ROLE_ADMIN);

            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("account", account);
            httpSession.setAttribute("isAdmin", isAdmin);
            httpSession.setAttribute("log", log);
            logServices.add(log);

            String destination = isAdmin ? PATH_VIEW_DASHBOARD : PATH_VIEW_PROFILE;
            resp.sendRedirect(destination);
        }
    }

    private void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);
        Object log = httpSession.getAttribute("log");

        if (log != null) {
            Log logTmp = (Log) log;
            logTmp.setLogoutTime(utils.convertLocalDateTimeToInstant(LocalDateTime.now()));
            logServices.update(logTmp);
        }

        httpSession.invalidate();
        resp.sendRedirect(PATH_VIEW_LOGIN);
    }

    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Update");
        String accountId = req.getParameter("accountId");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String status = req.getParameter("status");

        Account account = new Account(accountId, fullName, password, email, phone, Byte.parseByte(status));

        HttpSession session = req.getSession(true);
        boolean result = accountServices.updateAccount(account);
        if (!result) {
            resp.sendRedirect(PATH_VIEW_PROFILE + "?error=updateFailed");
            return;
        }

        // refresh data - new session - send attribute to view
        HttpSession session1 = req.getSession(true);
        session1.setAttribute("account", account);
        resp.sendRedirect(PATH_VIEW_PROFILE + "?success=updateSuccess");
    }

    private void handleChangePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);
        Account account = (Account) httpSession.getAttribute("account");

        String oldPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");

        if (!account.getPassword().equals(oldPassword)) {
            resp.sendRedirect(PATH_VIEW_CHANGE_PASSWORD + "?error=invalidPassword");
        }else{
            Account accountTmp = new Account(account.getAccountId(), account.getFullName(), newPassword, account.getEmail(), account.getPhone(), account.getStatus());

            boolean result = accountServices.updateAccount(accountTmp);

            if (!result) {
                resp.sendRedirect(PATH_VIEW_CHANGE_PASSWORD + "?error=updateFailed");
            }else{
                httpSession.setAttribute("account", accountTmp); // update new account in session
                resp.sendRedirect(PATH_VIEW_CHANGE_PASSWORD + "?success=updateSuccess");
                req.setAttribute("account", accountTmp);
            }


        }
    }
}
