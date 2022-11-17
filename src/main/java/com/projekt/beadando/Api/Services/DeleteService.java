package com.projekt.beadando.Api.Services;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

public interface DeleteService
{
    String hello();
    Response deleteUser(@HeaderParam("ID") String id);
    Response deleteMemberShip(@HeaderParam("ID") String id);
}
