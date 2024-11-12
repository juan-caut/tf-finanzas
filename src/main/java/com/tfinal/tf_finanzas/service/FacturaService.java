package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Letra;

import java.util.List;

public interface FacturaService {
    public void insert(Factura fac);
    List<Factura> list();
    public Factura listId(int id);
    public List<Factura> findAllByCarteraIs(int carteraId);

}