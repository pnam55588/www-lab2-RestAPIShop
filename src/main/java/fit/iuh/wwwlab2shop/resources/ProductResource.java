package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.models.Product;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/product")
public class ProductResource {
    @POST
    @Consumes("application/json")
    public boolean createProduct(Product product){
        return true;
    }
}
