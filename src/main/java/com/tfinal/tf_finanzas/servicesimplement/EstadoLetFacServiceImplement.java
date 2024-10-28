package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.EstadoLetFac;
import com.tfinal.tf_finanzas.repositories.EstadoLetFacRepository;
import com.tfinal.tf_finanzas.service.EstadoLetFacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoLetFacServiceImplement implements EstadoLetFacService {

    @Autowired
    private EstadoLetFacRepository cR;


    @Override
    public List<EstadoLetFac> list() {
        return cR.findAll();
    }

    @Override
    public void insert(EstadoLetFac est) {
        cR.save(est);
    }

    @Override
    public EstadoLetFac listId(int id) {
        return cR.findById( id).orElse(new EstadoLetFac());
    }
}

