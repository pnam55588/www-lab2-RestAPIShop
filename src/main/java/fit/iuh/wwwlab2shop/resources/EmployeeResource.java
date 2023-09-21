package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.services.EmployeeService;
import fit.iuh.wwwlab2shop.services.servicesImpl.EmployeeServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employee")
public class EmployeeResource {

    private EmployeeService employeeService;
    public EmployeeResource(){
        this.employeeService = new EmployeeServiceImpl();
    }

    @POST
    @Consumes("application/json")
    public Response createEmployee(Employee employee){
        boolean created = employeeService.create(employee);
        if(created){
            return Response.status(Response.Status.CREATED)
                    .header("Location", "/employee/" + employee.getId())
                    .entity("Employee created successfully")
                    .build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Employee creation failed")
                    .build();
        }
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> employees = employeeService.getAll();
        return Response.status(Response.Status.OK).entity(employees).build();
    }

    @PUT
    @Consumes("application/json")
    public Response update(Employee emp){
        boolean updated = employeeService.update(emp);
        if(updated){
            return  Response.status(Response.Status.OK)
                    .entity("Employee updated success")
                    .build();
        }else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Employee not found or status change failed")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int id){
        Employee employee = employeeService.findById(id);
        if(employee!=null){
            return Response.ok(employee).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @PUT
    @Path("/updateStatus/{id}")
    public Response changeStatus(@PathParam("id") int id,@QueryParam("status") EmployeeStatus status){
        boolean changed = employeeService.changeStatus(id, status);
        if(changed){
            return Response.status(Response.Status.OK).entity("status changed success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Employee not found or status change failed")
                    .build();
        }
    }

}
