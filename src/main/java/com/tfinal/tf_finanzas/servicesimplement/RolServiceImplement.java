package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Rol;
import com.tfinal.tf_finanzas.repositories.RolRepository;
import com.tfinal.tf_finanzas.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplement implements RolService {

    @Autowired
    private RolRepository cR;


    @Override
    public List<Rol> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        cR.save(rol);
    }

    @Override
    public Rol listId(int id) {
        return cR.findById(id).orElse(new Rol());
    }
}

