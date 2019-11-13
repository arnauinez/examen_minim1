package dsa.services;

import dsa.models.Product;
import dsa.project.ProductManager;
import dsa.project.ProductManagerImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//import dsa.utils.ProductManager;



@Api(value = "/products", description = "Endpoint to Product Service")
@Path("/products")
public class  ProductService {


    private ProductManager pm;

    public ProductService() {
        this.pm = ProductManagerImp.getInstance();
        if (pm.size()==0) {
            this.pm.addProduct(001, "COCACOLA",4, 4.5);
            this.pm.addProduct(002, "FANTA",5, 3.2);
            this.pm.addProduct(003, "BEER",10, 12.99);
        }
    }

    @GET
    @ApiOperation(value = "Getter.ProductsByPrice", notes = "Getter of products sorted by price(DESC)")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<Product> product = pm.getProductList_byPrice(0);

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(product) {};
        return Response.status(201).entity(entity).build() ;

    }

    @GET
    @ApiOperation(value = "get a Product", notes = "We look for an specific product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class),
            // @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int product_id) {
        Product t = this.pm.getProduct(product_id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "Delecte.Product", notes = "Product elimination")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int product_id) {
        Product t = this.pm.getProduct(product_id);
        if (t == null) return Response.status(404).build();
        else this.pm.popProduct(product_id);
        return Response.status(201).build();
    }


    @POST
    @ApiOperation(value = "create a new Product", notes = "We have a brand new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Product.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product product) {
        if (product.getProduct_name()==null || product.getPrice()==0)  return Response.status(500).entity(product).build();
        this.pm.addProduct(product.getId(), product.getProduct_name(), product.getQuantity(),product.getPrice());

        return Response.status(201).entity(product).build();
    }

}