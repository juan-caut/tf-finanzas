package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Coste;
import com.tfinal.tf_finanzas.repositories.CosteRepository;
import com.tfinal.tf_finanzas.service.CosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosteServiceImplement implements CosteService {

    @Autowired
    private CosteRepository cR;


    @Override
    public List<Coste> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Coste coste) {
        cR.save(coste);
    }

    @Override
    public Coste listId(int id) {
        return cR.findById(id).orElse(new Coste());
    }
}

