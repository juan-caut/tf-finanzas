package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Transaccion;
import com.tfinal.tf_finanzas.repositories.TransaccionRepository;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionServiceImplement implements TransaccionService {

    @Autowired
    private TransaccionRepository cR;


    @Override
    public List<Transaccion> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Transaccion transaccion) {
        cR.save(transaccion);
    }

    @Override
    public Transaccion listId(int id) {
        return cR.findById( id).orElse(new Transaccion());
    }
}

