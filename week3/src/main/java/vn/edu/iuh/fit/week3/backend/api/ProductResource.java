package vn.edu.iuh.fit.week3.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week3.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBeanRemote;

    @GET
    public Response getALl() {
        return Response.status(Response.Status.OK)
                .entity(productBeanRemote.getAll())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(productBeanRemote.getById(id))
                .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response add(Product product){
        try {
            if(productBeanRemote.add(product)){
                return Response.status(Response.Status.CREATED).entity(product).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity("Product is not added").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}
