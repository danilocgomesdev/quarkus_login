package danilocgomes.dev.modulos.usuario.service;

import danilocgomes.dev.core.exceptions.ApplicationExceptionBase;
import danilocgomes.dev.modulos.usuario.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import io.quarkus.logging.Log;

import java.util.List;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{


    @Override
    public Usuario buscarPorId(Long idUsuario){
        try {
            return Usuario.findById(idUsuario);
        } catch (Exception e){
            new ApplicationExceptionBase("Nao foi possivel Buscar usuario!");
            Log.warn("Erro ao buscar usuario na base");
        }
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        try {
            return Usuario.findAll().list();
        } catch (Exception e){
            new ApplicationExceptionBase("Nao foi possivel Buscar todos usuarios!");
            Log.warn("Erro ao todos usuarios na base");
        }
        return null;
    }

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario){
        try {
            Usuario.persist(usuario);
            Log.info("Usuario criado com sucesso!");
            return usuario;
        } catch (Exception e){
            new ApplicationExceptionBase("Nao foi possivel salvar!");
            Log.warn("Erro ao salvar usuario na base");
        }
        return null;
    }

}
