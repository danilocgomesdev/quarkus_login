package danilocgomes.dev.modulos.usuario.rest;


import danilocgomes.dev.modulos.usuario.model.Usuario;

import javax.ws.rs.core.Response;

public interface UsuarioApi {

    Response buscarPorId(Long id);

    Response salvarNovo(Usuario usuario);
}
