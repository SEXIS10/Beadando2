package com.projekt.beadando.Api.Resources;

import com.projekt.beadando.Api.Services.DeleteService;
import com.projekt.beadando.DataBase.DeleteFromDataBase;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/delete")
public class DeleteResource implements DeleteService
{
    @POST
    @Produces("text/plain")
    @Override
    public String hello() {
        return "Hello, World!";
    }
    @Path("/user")
    @POST
    @Override
    public Response deleteUser(@HeaderParam("ID") String id)
    {
        try
        {
            DeleteFromDataBase.deleteUser(Integer.parseInt(id));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.serverError().build();
        }

    }
    @Path("/user")
    @POST
    @Override
    public Response deleteMemberShip(@HeaderParam("ID") String id)
    {
        try
        {
            DeleteFromDataBase.deleteMemberShip(Integer.parseInt(id));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.serverError().build();
        }

    }
}
