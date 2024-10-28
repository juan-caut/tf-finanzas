package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.repositories.LetraRepository;
import com.tfinal.tf_finanzas.service.LetraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetraServiceImplement implements LetraService {

    @Autowired
    private LetraRepository cR;


    @Override
    public List<Letra> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Letra letra) {
        cR.save(letra);
    }

    @Override
    public Letra listId(int id) {
        return cR.findById( id).orElse(new Letra());
    }
}

