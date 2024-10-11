package vn.edu.iuh.fit.week3.frontend.controller;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week3.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.week3.backend.business.ProductPriceBeanRemote;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week3.backend.repositories.entities.ProductPrice;
import vn.edu.iuh.fit.week3.frontend.models.ProductModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/controller")
public class Controllers extends HttpServlet {

    @Inject
    private ProductModel productModel;

    @EJB
    private ProductBeanRemote productBeanRemote;

    @EJB
    private ProductPriceBeanRemote productPriceBeanRemote;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {

            case "productDetails":
                String productId = req.getParameter("product_id");

                Product productTMP = productBeanRemote.getById(Integer.parseInt(productId));
                List<ProductPrice> productPricesTMP = productPriceBeanRemote.getByIdProduct(productTMP.getId());

                req.setAttribute("product", productTMP);
                req.setAttribute("productPrices", productPricesTMP);

                req.getRequestDispatcher("productDetails.jsp").forward(req, resp);
                break;
            case "deleteProduct":
                String productIdDelete = req.getParameter("product_id");

                productPriceBeanRemote.deleteById(Integer.parseInt(productIdDelete));
                productBeanRemote.deleteById(Integer.parseInt(productIdDelete));

                resp.sendRedirect("index.html");
                break;

            case "addProduct":
                req.getRequestDispatcher("AddProductView.jsp").forward(req, resp);

                String name = req.getParameter("product_name");

                String description = req.getParameter("product_description");

                String imgPath = req.getParameter("img_path");
                int status = Integer.parseInt(req.getParameter("status"));
                double price = Double.parseDouble(req.getParameter("price"));
//                String note = req.getParameter("note");

                Product product = new Product(name, description, imgPath);
                productModel.createProduct(product);
                resp.sendRedirect("index.html");
                break;
            default:
                break;
        }
    }
}
