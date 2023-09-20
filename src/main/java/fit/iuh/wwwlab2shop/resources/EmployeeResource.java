package fit.iuh.wwwlab2shop.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/employee")
public class EmployeeResource {
    @POST
    @Consumes("application/json")
    public boolean createEmployee(){
        return true;
    }
}
