package com.tfinal.tf_finanzas.service;

import com.tfinal.tf_finanzas.entities.ConversionTasa;

import java.math.BigDecimal;
import java.util.List;

public interface ConversionTasaService {
    public BigDecimal insert(ConversionTasa conv);
    List<ConversionTasa> list();
    public ConversionTasa listId(int id);
public void delete(int id);
}