package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.Rol;

import java.util.List;

public interface RolService {
    public void insert(Rol rol);
    List<Rol> list();
    public Rol listId(int id);
}