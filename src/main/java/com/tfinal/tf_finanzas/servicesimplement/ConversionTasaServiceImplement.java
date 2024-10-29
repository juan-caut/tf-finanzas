package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.ConversionTasa;
import com.tfinal.tf_finanzas.repositories.ConversionTasaRepository;
import com.tfinal.tf_finanzas.service.ConversionTasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        BigDecimal teacalc = calculartea(conversionTasa);
        conversionTasa.setTasaEfectiva(teacalc);
        cR.save(conversionTasa);
    }

    @Override
    public ConversionTasa listId(int id) {
        return cR.findById( id).orElse(new ConversionTasa());
    }

    private static BigDecimal calculartea(ConversionTasa conversionTasa) {
        int periodotea=0;
        switch (conversionTasa.getCapitalizacion()) {
            case 1 -> periodotea = 360;
            case 15 -> periodotea = 24;
            case 30 -> periodotea = 12;
            case 60 -> periodotea = 6;
            case 90 -> periodotea = 4;
            case 120 -> periodotea = 3;
            case 180 -> periodotea = 2;
            case 360 -> periodotea = 1;
            default -> periodotea = 30;  // Valor por defecto si no coincide ningún caso
        }
        BigDecimal numeradorcalctn = conversionTasa.getTasaNominal().divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);

        int denominadorcalctn= conversionTasa.getTipoTasa()/conversionTasa.getCapitalizacion();

        BigDecimal teacalc1=numeradorcalctn.divide(BigDecimal.valueOf(denominadorcalctn),15, RoundingMode.HALF_UP)
                .add(BigDecimal.valueOf(1));

        BigDecimal teacalc2=teacalc1.pow(periodotea);

        BigDecimal teacalc3=teacalc2.subtract(BigDecimal.valueOf(1));
        BigDecimal teacalc4=teacalc3.multiply(BigDecimal.valueOf(100));
        return teacalc4;
    }

}

