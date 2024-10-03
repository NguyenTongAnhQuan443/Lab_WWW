package vn.edu.iuh.fit.www_week3_1.backend.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import vn.edu.iuh.fit.www_week3_1.backend.entities.Product;

public class ProductModel {
    private final String ADD_URL = ".api/products";
    public void createProduct(Product product) {
        try (Client client =  ClientBuilder.newClient()){
            WebTarget ws = client.target(ADD_URL);
            ws.request().post(jakarta.ws.rs.client.Entity.json(product));

        }
    }
}
