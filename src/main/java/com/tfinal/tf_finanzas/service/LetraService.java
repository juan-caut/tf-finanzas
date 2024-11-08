package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.entities.Letra;

import java.util.List;

public interface LetraService {
    public void insert(LetraDTO let);

    public void insertuptade(Letra let);
    List<Letra> list();
    public Letra listId(int id);
    public List<Letra> findAllByCarteraIs(int carteraId);
}