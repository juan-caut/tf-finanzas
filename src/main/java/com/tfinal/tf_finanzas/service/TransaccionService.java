package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.Transaccion;

import java.util.List;

public interface TransaccionService {
    public void insert(Transaccion transaccion);
    List<Transaccion> list();
    public Transaccion listId(int idTransaccion);
    public void updateCosts(int id);
}