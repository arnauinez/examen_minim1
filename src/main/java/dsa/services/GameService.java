package dsa.services;

import dsa.models.Product;
import dsa.models.User;
import dsa.project.GameManager;
import dsa.project.GameManagerImp;

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


@Api(value = "/users", description = "Endpoint to Users Service")
@Path("/users")
public class  GameService {


    private GameManager gm;

    public GameService() {
        this.gm = GameManagerImp.getInstance();
        if (gm.size()==0) {
            gm.addUser(000, "Arnau", "Martinez");
            gm.addUser(001, "Carlos", "Lopez");
            gm.addUser(002, "Snoop", "Dog");
            gm.addUser(003, "Kim", "Kardasian");
        }
    }

    @GET
    @ApiOperation(value = "Getter.SortedUsers", notes = "Getter of sorted users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<User> user = gm.getSortedUsersList();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(user) {};
        return Response.status(201).entity(entity).build() ;

    }

    @GET
    @ApiOperation(value = "Get User info", notes = "Quantity of users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int user_id) {
        User t = this.gm.getUser_byId(user_id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @POST
    @ApiOperation(value = "Add new User", notes = "Add new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User user) {
        //if (product.getProduct_name()==null || product.getPrice()==0)  return Response.status(500).entity(product).build();
        //this.pm.addProduct(product.getId(), product.getProduct_name(), product.getQuantity(),product.getPrice());
        this.gm.addUser(user.getId(), user.getName(), user.getSurname());

        return Response.status(201).entity(user).build();
    }

}