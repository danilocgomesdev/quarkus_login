package danilocgomes.dev.modulos.usuario.rest;


import javax.ws.rs.core.Response;

public interface UsuarioApi {

    Response buscarPorId(Long id);
}
