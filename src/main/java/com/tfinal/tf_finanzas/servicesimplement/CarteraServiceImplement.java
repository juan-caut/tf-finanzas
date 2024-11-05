package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.repositories.CarteraRepository;
import com.tfinal.tf_finanzas.service.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarteraServiceImplement implements CarteraService {

    @Autowired
    private CarteraRepository cR;


    @Override
    public List<Cartera> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cartera cartera) {
        cR.save(cartera);
    }

    @Override
    public Cartera listId(int id) {
        return cR.findById(id).orElse(new Cartera());
    }

    @Override
    public List<Cartera> getCarterasByUsuarioId(int usuarioId) {
        return cR.findAllByUsuarioCreador_Iduser(usuarioId);
    }
}

