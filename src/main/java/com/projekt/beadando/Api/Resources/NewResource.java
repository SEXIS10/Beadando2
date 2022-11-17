package com.projekt.beadando.Api.Resources;

import com.projekt.beadando.Api.Services.NewService;
import com.projekt.beadando.Classes.MemberShip;
import com.projekt.beadando.Classes.User;
import com.projekt.beadando.DataBase.InsertToDatabase;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.sql.Date;

import static java.lang.Integer.parseInt;

@Path("/new")
public class NewResource implements NewService
{
    InsertToDatabase insertToDatabase = new InsertToDatabase();
    @POST
    @Produces("text/plain")
    @Override
    public String hello() {
        return "Hello, World!";
    }
    @Path("/user")
    @POST
    @Override
    public Response newUser(@HeaderParam("uname") String name,
                            @HeaderParam("userName") String username,
                            @HeaderParam("email") String email,
                            @HeaderParam("Password") String pass,
                            @HeaderParam("birthPlace") String birthPlace,
                            @HeaderParam("birthDate") String birthDate,
                            @HeaderParam("sex") String sex,
                            @HeaderParam("natinality") String nationality)
    {
        try {
            insertToDatabase.insertIntoUserTable(new User(name,username,pass,email,Date.valueOf(birthDate),birthPlace,sex,true,nationality));
            return Response.ok().build();
        }
        catch (Exception e)
        {

            return Response.ok(e.getStackTrace()).build();
        }
    }
    @Path("/membership")
    @POST
    @Override
    public Response newMemberShip(@HeaderParam("Mnumber") String Mnumber,
                                  @HeaderParam("UserID") String userID,
                                      @HeaderParam("Exipry") String Expiry
    )
    {
        try {
            insertToDatabase.insertIntoMemberShipTable(new MemberShip(parseInt(Mnumber), parseInt(userID), Date.valueOf(Expiry)));
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
