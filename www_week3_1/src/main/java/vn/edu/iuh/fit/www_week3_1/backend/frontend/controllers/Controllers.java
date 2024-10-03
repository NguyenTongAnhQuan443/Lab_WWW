package vn.edu.iuh.fit.www_week3_1.backend.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.www_week3_1.backend.entities.Product;
import vn.edu.iuh.fit.www_week3_1.backend.frontend.models.ProductModel;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controllers extends HttpServlet {
    @Inject
    private ProductModel productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("add")){
            String name = req.getParameter("name");
            String desc = req.getParameter("desc");
            String img = req.getParameter("img");
            productModel.createProduct(new Product(name, desc, img));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
