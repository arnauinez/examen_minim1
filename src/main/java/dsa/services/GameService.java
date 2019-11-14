package dsa.services;

import dsa.models.Obj;
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
            this.gm.addUser(000, "Arnau", "Martinez");
            this.gm.addUser(001, "Carlos", "Lopez");
            this.gm.addUser(002, "Snoop", "Dog");
            this.gm.addUser(003, "Kim", "Kardasian");

            gm.addObj(000, 999, "espada", true, 100);
            gm.addObj(000, 888, "escudo", false, 50);
            gm.addObj(000, 777, "hechizo", false, 30);
        }
    }

    @GET
    @ApiOperation(value = "Getter SortedUsers", notes = "Getter of sorted users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersSorted() {
        List<User> _user = this.gm.getSortedUsersList();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(_user) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Getter SortedUsers", notes = "Getter of sorted users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/obj/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects_fromUser(@PathParam("id") int user_id) {
        List<Obj> _obj = this.gm.getObj_fromUser(user_id);

        GenericEntity<List<Obj>> entity = new GenericEntity<List<Obj>>(_obj) {};
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get User info", notes = "Quantity of users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int user_id) {
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
        if (user.getName()==null || user.getSurname()==null)  return Response.status(500).entity(user).build();
        //this.pm.addProduct(product.getId(), product.getProduct_name(), product.getQuantity(),product.getPrice());
        this.gm.addUser(user.getId(), user.getName(), user.getSurname());

        return Response.status(201).entity(user).build();
    }
    @POST
    @ApiOperation(value = "Add new object", notes = "Add new obj")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Obj.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int user_id, Obj obj) {
        this.gm.addObj(user_id, obj.getId(),obj.getName(), obj.isObj_type(), obj.getScore());
        return Response.status(201).entity(obj).build();
    }
    @PUT
    @ApiOperation(value = "User update", notes = "Nice update")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    public Response updateUser(User user) {

        User t = this.gm.modUser(user.getId(), bool, );

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

}