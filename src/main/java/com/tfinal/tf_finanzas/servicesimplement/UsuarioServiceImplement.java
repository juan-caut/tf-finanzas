package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.dto.UsuarioRequest;
import com.tfinal.tf_finanzas.entities.Rol;
import com.tfinal.tf_finanzas.entities.Usuario;
import com.tfinal.tf_finanzas.repositories.RolRepository;
import com.tfinal.tf_finanzas.repositories.UsuarioRepository;
import com.tfinal.tf_finanzas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository cR;
@Autowired
private RolRepository rolRepository;
    @Override
    public List<Usuario> list() {
        return cR.findAll();
    }

    @Override
    public void insert(UsuarioRequest user) {

        Usuario usuario = new Usuario();
        usuario.setUsername(user.getUsername());
        usuario.setIdent(user.getIdent());
        usuario.setEmail(user.getEmail());
        usuario.setPassword(user.getPasswordd());
        usuario.setFechacreacion(new Date());
        usuario.setEstado("ACTIVO");
        Rol rol = rolRepository.findById((user.getIdRol())).orElse(null);
        usuario.setRol(rol);
        cR.save(usuario);
    }

    @Override
    public Usuario listId(int id) {
        return cR.findById(id).orElse(new Usuario());
    }

    @Override
    public Usuario getUsuariobyusername(String username) {
        return cR.findByUsername(username);
    }

    @Override
    public String verificationUser(String ident) {
        return cR.verificationUser(ident);
    }

    @Override
    public String authUser(String username, String pass) {
        return cR.authUser(username,pass);
    }
}


