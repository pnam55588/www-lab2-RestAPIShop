package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.repositories.CustomerRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    @POST
    @Consumes("application/json")
    public boolean createCustomer(Customer customer){
        System.out.println(customer);
        return true;
    }
}
