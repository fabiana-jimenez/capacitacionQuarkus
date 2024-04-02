package co.com.samtel.usuario.service.contract;

import co.com.samtel.usuario.gen.type.UsuarioTypeInput;
import co.com.samtel.usuario.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {

    UsuarioTypeResponse crearUsuario (UsuarioTypeInput usuarioTypeInput);

    public List<UsuarioTypeResponse> listarUsuario(Integer id);
}
