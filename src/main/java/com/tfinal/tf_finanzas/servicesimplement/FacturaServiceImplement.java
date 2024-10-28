package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.repositories.FacturaRepository;
import com.tfinal.tf_finanzas.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImplement implements FacturaService {

    @Autowired
    private FacturaRepository cR;


    @Override
    public List<Factura> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Factura fact) {
        cR.save(fact);
    }

    @Override
    public Factura listId(int id) {
        return cR.findById(id).orElse(new Factura());
    }
}

