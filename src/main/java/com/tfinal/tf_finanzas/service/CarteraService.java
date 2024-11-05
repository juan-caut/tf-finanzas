package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.Cartera;

import java.util.List;

public interface CarteraService {
    public void insert(Cartera cartera);
    List<Cartera> list();
    public Cartera listId(int id);
    public List<Cartera> getCarterasByUsuarioId(int usuarioId);
}