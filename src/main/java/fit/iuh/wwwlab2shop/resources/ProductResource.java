package fit.iuh.wwwlab2shop.resources;

import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductImage;
import fit.iuh.wwwlab2shop.models.ProductPrice;
import fit.iuh.wwwlab2shop.services.ProductService;
import fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/product")
public class ProductResource {

    private final ProductService productService;
    public ProductResource(){
        this.productService = new ProductServiceImpl();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createProduct(Product product){
        boolean created = productService.create(product);
        if(created){
            return Response.status(Response.Status.CREATED).entity("product created success").build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GET
    @Path("/paging")
    @Produces("application/json")
    public Response paging(@QueryParam("page") int page,@QueryParam("limit") int limit){
        List<Product> products =productService.paging(page,limit);
        return Response.ok(products).build();
    }
    @GET
    @Produces("application/json")

    public Response getAll(){
        List<Product> products =productService.getAll();
        return Response.ok(products).build();
    }
    @GET
    @Path("/getImages/{id}")
    @Produces("application/json")
    public Response getImages(@PathParam("id") int id){
        List<ProductImage> productImages = productService.getImages(id);
        return Response.ok(productImages).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int id){
        Product product = productService.findById(id);
        if(product!=null){
            return Response.status(Response.Status.OK).entity(product).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error find product").build();
        }
    }
    @GET
    @Path("/getPrice/{id}")
    @Produces("application/json")
    public Response getPrice(@PathParam("id") int id){
        ProductPrice productPrice = productService.getPrice(id);
        if(productPrice!=null){
            return Response.status(Response.Status.OK).entity(productPrice).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product price not found or error find product price").build();
        }
    }
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Product product){
        boolean updated = productService.update(product);
        if(updated){
            return Response.status(Response.Status.OK).entity("product update success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error to update product").build();
        }
    }
    @PUT
    @Path("/active/{id}")
    @Produces("application/json")
    public Response active(@PathParam("id") int id){
        boolean actived = productService.active(id);
        if(actived){
            return Response.status(Response.Status.OK).entity("product update success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error to active product").build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") int id){
        boolean deleted = productService.delete(id);
        if(deleted){
            return Response.status(Response.Status.OK).entity("product deleted success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error to delete product").build();
        }
    }
    @PUT
    @Path("/updatePrice")
    @Produces("application/json")
    public Response updatePrice(@QueryParam("id") int id,@QueryParam("price") double price){
        boolean updated = productService.updatePrice(id,price);
        if(updated){
            return Response.status(Response.Status.OK).entity("product updated success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error to update product").build();
        }
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addImages (ImageRequest imageRequest){
        int id = imageRequest.getId();
        List<String> paths = imageRequest.getPaths();
        boolean inserted = productService.addImages(id,paths);
        if(inserted){
            return Response.status(Response.Status.OK).entity("images inserted success").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("product not found or error to insert images").build();
        }

    }
    @DELETE
    @Path("/productImage/{id}")
    @Produces("application/json")
    public Response deleteImage(@PathParam("id") int idImg){
        boolean deleted = productService.deleteImage(idImg);
        if(deleted){
            return Response.status(Response.Status.OK).entity("image deleted").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("image not found or error to delete image").build();
        }
    }
}

class ImageRequest {
    private int id;
    private List<String> paths;

    public ImageRequest() {
    }

    public ImageRequest(int id, List<String> paths) {
        this.id = id;
        this.paths = paths;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return "ImageRequest{" +
                "id=" + id +
                ", paths=" + paths +
                '}';
    }
}
