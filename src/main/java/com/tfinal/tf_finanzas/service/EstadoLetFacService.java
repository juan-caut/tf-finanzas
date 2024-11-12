package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.EstadoLetFac;

import java.util.List;

public interface EstadoLetFacService {
    public void insert(EstadoLetFac est);
    List<EstadoLetFac> list();
    public EstadoLetFac listId(int id);
    public void delete(int id);
}