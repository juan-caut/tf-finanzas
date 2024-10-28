package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.ConversionTasa;
import com.tfinal.tf_finanzas.repositories.ConversionTasaRepository;
import com.tfinal.tf_finanzas.service.ConversionTasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionTasaServiceImplement implements ConversionTasaService {
    @Autowired
    private ConversionTasaRepository cR;


    @Override
    public List<ConversionTasa> list() {
        return cR.findAll();
    }

    @Override
    public void insert(ConversionTasa conversionTasa) {
        cR.save(conversionTasa);
    }

    @Override
    public ConversionTasa listId(int id) {
        return cR.findById( id).orElse(new ConversionTasa());
    }
}

