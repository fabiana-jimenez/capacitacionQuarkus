package co.com.samtel.usuario.controller;

import co.com.samtel.usuario.gen.contract.V1UsuarioApi;
import co.com.samtel.usuario.gen.type.UsuarioTypeInput;
import co.com.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.com.samtel.usuario.service.impl.UsuarioServiceImpl;
import co.com.samtel.usuario.utils.ApplicationException;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import static co.com.samtel.usuario.constant.Constant.ERROR_CONTROLLER;


public class UsuarioController implements V1UsuarioApi {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioServiceImpl usuarioServiceImpl;
    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) throws ApplicationException {
        LOG.info("Inicia endPoint de crearUsuarioController");
        try {
            Object  usuarioType = usuarioServiceImpl.crearUsuario(usuarioTypeInput);
            LOG.info("Termina endPoint de crearUsuarioController");
            return (List<UsuarioTypeResponse>) usuarioType;
        }catch (ApplicationException e){
            LOG.error("Ocurrio un error en el controller al crear el usuario " + e.getMessage());
            throw new ApplicationException(ERROR_CONTROLLER + e.getMessage() + "crearUsuarioController");
        }
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser) {
        LOG.info("Inicia endPoint de listarUsuarioController");
        try {
            Object usuarioType = usuarioServiceImpl.listarUsuario(idtblUser);
            LOG.info("Termina endPoint de listarUsuarioController");
            return (List<UsuarioTypeResponse>) usuarioType;
        }catch (ApplicationException e){
            LOG.error("Ocurrio un error en el controller al crear el usuario " + e.getMessage());
            throw new ApplicationException(ERROR_CONTROLLER + e.getMessage() + "crearUsuarioController");
        }
    }
}
