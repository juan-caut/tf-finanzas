package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.ConversionTasa;

import java.util.List;

public interface ConversionTasaService {
    public void insert(ConversionTasa conv);
    List<ConversionTasa> list();
    public ConversionTasa listId(int id);
}