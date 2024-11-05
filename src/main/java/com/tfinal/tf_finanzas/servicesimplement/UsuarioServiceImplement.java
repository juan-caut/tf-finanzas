package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Rol;
import com.tfinal.tf_finanzas.entities.Usuario;
import com.tfinal.tf_finanzas.repositories.UsuarioRepository;
import com.tfinal.tf_finanzas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository cR;

    @Override
    public List<Usuario> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Usuario user) {
        if(user.getEstado()==null && user.getRol()==null){
            user.setRol(new Rol(2,"EMPLOYEE"));
            user.setEstado("INACTIVO");
        }

        cR.save(user);
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


