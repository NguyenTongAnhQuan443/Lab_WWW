package vn.edu.iuh.fit.week3.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;

public class ProductModel {

    private final String ADD_URL = ("http://localhost:8080/week3-1.0-SNAPSHOT/api/products");

    public void addProduct(Product product) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget webTarget = client.target(ADD_URL);

            Response response = webTarget.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
