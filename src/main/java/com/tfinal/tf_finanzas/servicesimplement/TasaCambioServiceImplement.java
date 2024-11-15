package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.TasaCambio;
import com.tfinal.tf_finanzas.repositories.TasaCambioRepository;
import com.tfinal.tf_finanzas.service.TasaCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasaCambioServiceImplement implements TasaCambioService {

    @Autowired
    private TasaCambioRepository cR;


    @Override
    public List<TasaCambio> list() {
        return cR.findAll();
    }

    @Override
    public void insert(TasaCambio tasaCambio) {
        cR.save(tasaCambio);
    }

    @Override
    public TasaCambio listId(int id) {
        return cR.findById( id).orElse(new TasaCambio());
    }

    @Override
    public void delete(int idTasaCambio) {
        cR.deleteById(idTasaCambio);
    }

}

