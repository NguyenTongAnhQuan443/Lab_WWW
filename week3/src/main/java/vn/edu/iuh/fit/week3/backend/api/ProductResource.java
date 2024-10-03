package vn.edu.iuh.fit.week3.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week3.backend.business.ProductBean;
import vn.edu.iuh.fit.week3.backend.repositories.entity.Product;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBean productBean;

    @GET
    public Response getALl() {
        return Response.ok(productBean.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(productBean.getById(id)).build();
    }

    @POST
    public Response create(Product product){
        return Response.ok(productBean.add(product)).build();
    }

}
