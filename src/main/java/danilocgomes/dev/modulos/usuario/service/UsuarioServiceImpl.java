package danilocgomes.dev.modulos.usuario.service;

import danilocgomes.dev.modulos.usuario.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{


    @Override
    public Usuario getById(Long idUsuario){
        Usuario usuario = Usuario.findById(idUsuario);
        if(usuario == null){
            throw new NotFoundException();
        }else {
            return usuario;
        }
    }

    @Override
    @Transactional
    public void salvar(Usuario usuario){
        Usuario.persist(usuario);
    }
}
