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
    public BigDecimal insert(ConversionTasa conversionTasa) {
        BigDecimal teacalc = calculartea(conversionTasa);
        conversionTasa.setTasaEfectiva(teacalc);
        cR.save(conversionTasa);
        return teacalc;
    }

    @Override
    public ConversionTasa listId(int id) {
        return cR.findById( id).orElse(new ConversionTasa());
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    private static BigDecimal calculartea(ConversionTasa conversionTasa) {

        int n=0;
        switch (conversionTasa.getCapitalizacion()) {
            case 1 -> n = 360;
            case 15 -> n = 24;
            case 30 -> n = 12;
            case 60 -> n = 6;
            case 90 -> n = 4;
            case 120 -> n = 3;
            case 180 -> n = 2;
            case 360 -> n = 1;
            default -> n = 30;  // Valor por defecto si no coincide ningún caso
        }
        //CONVERTIR TASA NOMINAL A PROPORCIÓN
        BigDecimal TNenproporcion = conversionTasa.getTasaNominal().divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);

        //CALCULAR TEA
        double m = (double)conversionTasa.getTipoTasa()/conversionTasa.getCapitalizacion();

        BigDecimal teacalc1=TNenproporcion.divide(BigDecimal.valueOf(m),15, RoundingMode.HALF_UP)
                .add(BigDecimal.valueOf(1));

        BigDecimal teacalc2=teacalc1.pow(n);

        BigDecimal teacalc3=teacalc2.subtract(BigDecimal.valueOf(1));
        BigDecimal TEA=teacalc3.multiply(BigDecimal.valueOf(100));
        return TEA;
    }


}

