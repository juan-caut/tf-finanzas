package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.TasaCambio;

import java.util.List;

public interface TasaCambioService {
    public void insert(TasaCambio tasaCambio);
    List<TasaCambio> list();
    public TasaCambio listId(int idTasaCambio);
}