package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.entities.Letra;

import java.util.List;

public interface LetraService {
    public void insert(Letra let);
    List<Letra> list();
    public Letra listId(int id);
    public List<Letra> findAllByCarteraIs(int carteraId);
}