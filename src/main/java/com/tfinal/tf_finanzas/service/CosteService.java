package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.Coste;

import java.util.List;

public interface CosteService {
    public void insert(Coste cos);
    List<Coste> list();
    public Coste listId(int id);
}