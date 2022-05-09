package danilocgomes.dev.modulos.usuario.rest;


import danilocgomes.dev.modulos.usuario.model.Usuario;
import danilocgomes.dev.modulos.usuario.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest implements UsuarioApi{

    @Inject
    UsuarioService usuarioService;

    @GET
    @Path("/{id}")
    @Override
    public Response buscarPorId(@PathParam("id") Long id){
        return Response.ok(usuarioService.getById(id)).build();
    }

    @POST
    @Override
    public Response salvarNovo(Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            Logger.getLogger("Nao foi possivel salvar!");
        }
        return null;
    }
}
