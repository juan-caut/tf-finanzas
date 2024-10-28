package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Descuento;
import com.tfinal.tf_finanzas.repositories.DescuentoRepository;
import com.tfinal.tf_finanzas.service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoServiceImplement implements DescuentoService {

    @Autowired
    private DescuentoRepository cR;


    @Override
    public List<Descuento> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Descuento desc) {
        cR.save(desc);
    }

    @Override
    public Descuento listId(int id) {
        return cR.findById(id).orElse(new Descuento());
    }
}

