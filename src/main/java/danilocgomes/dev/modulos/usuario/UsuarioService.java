package danilocgomes.dev.modulos.usuario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioService {


    Usuario getById(Long idUsuario){
        return Usuario.findById(idUsuario);
    }
}
