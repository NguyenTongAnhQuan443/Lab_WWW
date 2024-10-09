package vn.edu.iuh.fit.week3.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week3.frontend.models.ProductModel;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/controller")
public class Controllers extends HttpServlet {

    @Inject
    private ProductModel productModel;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                String name = req.getParameter("product_name");
                String description = req.getParameter("product_description");
                String imgPath = req.getParameter("img_path");
                Product product = new Product(name, description, imgPath);
                productModel.createProduct(product);
                resp.sendRedirect("index.jsp");
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }
}
