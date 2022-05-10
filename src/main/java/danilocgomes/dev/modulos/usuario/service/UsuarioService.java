package danilocgomes.dev.modulos.usuario.service;

import danilocgomes.dev.modulos.usuario.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario buscarPorId(Long idUsuario);

    List<Usuario> buscarTodos();

    Usuario salvar(Usuario usuario);
}
