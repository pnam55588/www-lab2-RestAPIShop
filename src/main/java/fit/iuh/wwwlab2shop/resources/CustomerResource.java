package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.services.CustomerService;
import fit.iuh.wwwlab2shop.services.servicesImpl.CustomerServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customer")
public class CustomerResource {
    private final CustomerService customerService;
    public  CustomerResource(){
        customerService = new CustomerServiceImpl();
    }
    @POST
    @Consumes("application/json")
    public Response create(Customer customer){
        boolean created =  customerService.create(customer);
        if(created){
            return Response.status(Response.Status.CREATED)
                    .header("Location", "/customer/" + customer.getId())
                    .entity("Customer created successfully")
                    .build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Customer creation failed")
                    .build();
        }
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> customers = customerService.getAll();
        return Response.status(Response.Status.OK).entity(customers).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Customer cust){
        boolean updated = customerService.update(cust);
        if(updated){
            return  Response.status(Response.Status.OK)
                    .entity("customer updated success")
                    .build();
        }else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("customer not found or status change failed")
                    .build();
        }
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int id){
        Customer customer = customerService.findById(id);
        if(customer!=null){
            return Response.ok(customer).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @GET
    @Path("/paging")
    @Produces("application/json")
    public Response paging(@QueryParam("page") int page,@QueryParam("limit") int limit){
        List<Customer> customers = customerService.paging(page, limit);
        return Response.status(Response.Status.OK).entity(customers).build();
    }
}
