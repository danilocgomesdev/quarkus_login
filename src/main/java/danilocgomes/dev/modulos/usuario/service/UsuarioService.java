package danilocgomes.dev.modulos.usuario.service;

import danilocgomes.dev.modulos.usuario.model.Usuario;

public interface UsuarioService {

    Usuario getById(Long idUsuario);

    Usuario salvar(Usuario usuario);
}
