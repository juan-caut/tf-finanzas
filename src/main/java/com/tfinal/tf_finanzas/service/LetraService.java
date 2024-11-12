package com.tfinal.tf_finanzas.service;
import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.dto.LetraeditDTO;
import com.tfinal.tf_finanzas.entities.Letra;

import java.util.List;

public interface LetraService {
    public Letra insert(LetraDTO let);

    public void insertuptade(LetraeditDTO let);
    List<Letra> list();
    public Letra listId(int id);
    public List<Letra> findAllByCarteraIs(int carteraId);
    public void delete(int id,TransaccionService transaccionService);
}