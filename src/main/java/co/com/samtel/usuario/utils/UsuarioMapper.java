package co.com.samtel.usuario.utils;

import co.com.samtel.usuario.entity.Usuario;
import co.com.samtel.usuario.gen.type.UsuarioTypeInput;
import co.com.samtel.usuario.gen.type.UsuarioTypeResponse;
import io.vertx.codegen.Model;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario usuarioTypeInput(UsuarioTypeInput usuarioType){
        return new ModelMapper().map(usuarioType, Usuario.class);
    }

    public UsuarioTypeInput usuarioEntityToTypeResponse(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeInput.class);
    }
    public UsuarioTypeResponse usuarioTypeResponse(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }
}
