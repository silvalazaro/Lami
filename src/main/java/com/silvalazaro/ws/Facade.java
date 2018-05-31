package com.silvalazaro.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Representa uma fachada de um recurso do Web Service
 *
 * @author Lazaro Silva
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class Facade {
    
    @GET
    @Path("{id}")
    public Response selecionar(@PathParam("id") String id) {
        return Response.ok().build();
    }
    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") String id) {
        return Response.ok().build();
    }
    @GET
    @Path("/")
    public Response listar() {
        return Response.ok().build();
    }
    @PUT
    @Path("")
    public Response atualizar() {
        return Response.ok().build();
    }
    
}
