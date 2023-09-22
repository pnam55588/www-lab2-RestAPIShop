package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Orders;
import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.services.OrderService;
import fit.iuh.wwwlab2shop.services.ProductService;
import fit.iuh.wwwlab2shop.services.servicesImpl.OrderServiceImpl;
import fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl;
import jakarta.faces.push.Push;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Path("/order")
public class OrderResource {
    private final OrderService orderService;
    private final ProductService productService;

    public OrderResource(){
        this.orderService =new OrderServiceImpl();
        this.productService = new ProductServiceImpl();

    }

    @GET
    @Path("/paging")
    @Produces("application/json")
    public Response paging(@QueryParam("page") int page,@QueryParam("limit") int limit){
        List<Orders> orders= orderService.paging(page, limit);
        return Response.status(Response.Status.OK).entity(orders).build();
    }
    @GET
    @Path("/findByMonth")
    @Produces("application/json")
    public Response findByMonth(@QueryParam("month") int month,@QueryParam("year") int year){
        List<Orders> orders= orderService.findByMonth(month, year);
        return Response.status(Response.Status.OK).entity(orders).build();
    }
    @GET
    @Path("/findByEmpAnhMonth")
    @Produces("application/json")
    public Response findByEmpAnhMonth(int idEmp, int month, int year){
        List<Orders> orders= orderService.findByEmpAnhMonth(idEmp,month, year);
        return Response.status(Response.Status.OK).entity(orders).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(OrderRequest orderRequest){
        int empId = orderRequest.getEmpId();
        int custId = orderRequest.getCustId();
        List<OrderDetail> ods = new ArrayList<OrderDetail>();
        for (OrderDetailRequest odr : orderRequest.getOds()) {
            OrderDetail orderDetail = new OrderDetail();
            Product product = productService.findById(odr.getProdId());
            if (product == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("product not found").build();
            }
            orderDetail.setProduct(product);
            if(odr.getPrice() == 0.0){
                orderDetail.setPrice(productService.getPrice(odr.getProdId()).getPrice());
            }else {
                orderDetail.setPrice(odr.getPrice());
            }
            orderDetail.setNote(odr.getNote());
            orderDetail.setQuantity(odr.getQuantity());
            ods.add(orderDetail);
        }
        boolean created = orderService.create(empId,custId,ods);
        if(created){
            return Response.status(Response.Status.OK).entity("order created").build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error to create order").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int id) {
        Orders order = orderService.findById(id);
        if (order != null) {
            return Response.status(Response.Status.OK).entity(order).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("order not found").build();
        }
    }
}

class OrderRequest{
    private int empId;
    private int custId;

    private Set<OrderDetailRequest> ods;

    public OrderRequest() {
    }

    public int getEmpId() {
        return empId;
    }

    public int getCustId() {
        return custId;
    }

    public Set<OrderDetailRequest> getOds() {
        return ods;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "empId=" + empId +
                ", custId=" + custId +
                ", ods=" + ods +
                '}';
    }
}
class OrderDetailRequest{
    private int prodId;
    private int quantity;
    private double price;
    private String note;

    public OrderDetailRequest() {
    }

    public int getProdId() {
        return prodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailRequest that = (OrderDetailRequest) o;
        return prodId == that.prodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId);
    }

    @Override
    public String toString() {
        return "OrderDetailRequest{" +
                "prodId=" + prodId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
