package com.projekt.beadando.Api.Resources;

import com.projekt.beadando.Api.Services.GetService;
import com.projekt.beadando.Classes.MemberShip;
import com.projekt.beadando.Classes.User;
import com.projekt.beadando.DataBase.GetDataFromDatabase;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;

@Path("/get")
public class GetResource implements GetService {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers()
    {
        for (User user :
                GetDataFromDatabase.getDataFromUserTable())
        {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(user.getName());
            jsonArray.put(user.getUsername());
            jsonArray.put(user.getPassword());
            jsonArray.put(user.getEmail());
            jsonArray.put(user.getSex());
            jsonArray.put(user.getBirthdate());
            jsonArray.put(user.getBirthplace());
            jsonArray.put(user.getNationality());
            return Response.ok(jsonArray.toString()).build();
        }
        return null;
    }
    @GET
    @Path("/memberships")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getmemberships()
    {
        for (MemberShip user :
                GetDataFromDatabase.getDataFromMemberShipTable())
        {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(user.getMnumber());
            jsonArray.put(user.getUserid());
            jsonArray.put(user.getExpiriy());
            return Response.ok(jsonArray.toString()).build();
        }
        return null;
    }
}