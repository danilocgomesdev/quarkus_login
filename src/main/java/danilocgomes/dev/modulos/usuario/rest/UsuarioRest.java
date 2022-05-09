package danilocgomes.dev.modulos.usuario.rest;


import danilocgomes.dev.modulos.usuario.service.UsuarioServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest implements UsuarioApi{

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @GET
    @Path("/{id}")
    @Override
    public Response buscarPorId(@PathParam("id") Long id){
        return Response.ok(usuarioServiceImpl.getById(id)).build();
    }
}
