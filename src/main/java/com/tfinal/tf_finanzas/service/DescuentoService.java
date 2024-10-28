package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.Descuento;

import java.util.List;

public interface DescuentoService {
    public void insert(Descuento desc);
    List<Descuento> list();
    public Descuento listId(int id);
}