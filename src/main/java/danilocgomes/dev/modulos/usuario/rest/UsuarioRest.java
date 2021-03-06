package danilocgomes.dev.modulos.usuario.rest;


import danilocgomes.dev.modulos.usuario.model.Usuario;
import danilocgomes.dev.modulos.usuario.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest implements UsuarioApi{

    @Inject
    UsuarioService usuarioService;

    @GET
    @Path("/{id}")
    @Override
    public Response buscarPorId(@PathParam("id") Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        if(usuario != null)
            return Response.ok(usuario).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Override
    public Response buscarTodos() {
        List<Usuario> usuarioList = usuarioService.buscarTodos();
        if(usuarioList != null)
            return Response.ok(usuarioList).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Override
    public Response salvarNovo(Usuario usuario) {
        usuarioService.salvar(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }
}
