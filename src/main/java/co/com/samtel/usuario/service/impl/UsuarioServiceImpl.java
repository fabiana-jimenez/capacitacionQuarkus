package co.com.samtel.usuario.service.impl;

import co.com.samtel.usuario.controller.UsuarioController;
import co.com.samtel.usuario.dao.UsuarioDao;
import co.com.samtel.usuario.entity.Usuario;
import co.com.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.com.samtel.usuario.service.contract.IUsuarioService;
import co.com.samtel.usuario.gen.type.UsuarioTypeInput;
import co.com.samtel.usuario.utils.ApplicationException;
import co.com.samtel.usuario.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.com.samtel.usuario.constant.Constant;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static co.com.samtel.usuario.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class UsuarioServiceImpl implements IUsuarioService{

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    @Override
    public UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia el service de crearUsuario");
        UsuarioTypeResponse usuarioTypeResponses;
        try{
            Usuario usuario =usuarioMapper.usuarioTypeInput(usuarioTypeInput);
            usuarioDao.persist(usuario);
            usuarioTypeResponses = usuarioMapper.usuarioTypeResponse(usuario);
            usuarioDao.persist(usuario);
            LOG.info("Finaliza service crearUsuario");
        }catch (ApplicationException e){
            LOG.error("Ocurrio un error al devolver la respuesta de la creacion del usuario " + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crearUsuarioService");
        }
      return usuarioTypeResponses;
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer id) {
        LOG.info("Inicia en listarUsuario");
        try {
        Long idUser = Long.valueOf(id);
        Usuario user = usuarioDao.findById(idUser);
        UsuarioTypeResponse res = usuarioMapper.usuarioTypeResponse(user);
        LOG.info("Termina el metodo listarUsuario");
        return Collections.singletonList(res);
        } catch (ApplicationException e) {
            LOG.error("Ocurrio un error al devolver la respuesta de listar el usuario " + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "listarUsuarioService");
        }
    }
}
