package com.projekt.beadando.Api.Services;

import jakarta.ws.rs.core.Response;

public interface GetService
{
    String hello();
    Response getUsers();
    Response getmemberships();
}
