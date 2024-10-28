package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.Factura;

import java.util.List;

public interface FacturaService {
    public void insert(Factura fac);
    List<Factura> list();
    public Factura listId(int id);
}