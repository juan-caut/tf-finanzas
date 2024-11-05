package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public void insert(Usuario us);
    List<Usuario> list();
    public Usuario listId(int idUsuario);
    public String verificationUser(String ident);
    public String authUser(String username, String pass);
}