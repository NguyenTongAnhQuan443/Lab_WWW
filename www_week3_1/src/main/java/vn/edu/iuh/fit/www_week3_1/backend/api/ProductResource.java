package vn.edu.iuh.fit.www_week3_1.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_week3_1.backend.entities.Product;
import vn.edu.iuh.fit.www_week3_1.backend.businessBean.ProductBeanRemote;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBeanRemote;

    @GET
    public Response getAll(){
        return Response.ok(productBeanRemote.getAll()).build();
    }

    @GET
    public Response getById(int id){
        return Response.ok(productBeanRemote.getById(id)).build();
    }
    @POST
    public Response create(Product product){
        return Response.ok(product).build();
    }
}
