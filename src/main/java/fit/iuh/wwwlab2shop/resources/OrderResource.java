package fit.iuh.wwwlab2shop.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/order")
public class OrderResource {

    @GET
    @Produces("application/json") // tra ve
    public String test(){
        return "test";
    }
}
