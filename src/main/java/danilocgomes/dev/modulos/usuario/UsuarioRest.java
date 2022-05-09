package danilocgomes.dev.modulos.usuario;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {

    @Inject
    UsuarioService usuarioService;

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id){
        return Response.ok(usuarioService.getById(id)).build();
    }
}
