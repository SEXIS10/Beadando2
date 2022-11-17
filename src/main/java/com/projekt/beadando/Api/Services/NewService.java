package com.projekt.beadando.Api.Services;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

public interface NewService
{
    public String hello();
    public Response newUser(@HeaderParam("uname") String name,
                            @HeaderParam("userName") String username,
                            @HeaderParam("email") String email,
                            @HeaderParam("Password") String pass,
                            @HeaderParam("birthPlace") String birthPlace,
                            @HeaderParam("birthDate") String birthDate,
                            @HeaderParam("sex") String sex,
                            @HeaderParam("natinality") String nationality);
    public Response newMemberShip(@HeaderParam("Mnumber") String Mnumber,
                                  @HeaderParam("UserID") String userID,
                                  @HeaderParam("Exipry") String Expiry);
}
