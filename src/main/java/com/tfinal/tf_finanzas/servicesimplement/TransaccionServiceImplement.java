package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Coste;
import com.tfinal.tf_finanzas.entities.Transaccion;
import com.tfinal.tf_finanzas.repositories.CosteRepository;
import com.tfinal.tf_finanzas.repositories.LetraRepository;
import com.tfinal.tf_finanzas.repositories.TransaccionRepository;
import com.tfinal.tf_finanzas.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class TransaccionServiceImplement implements TransaccionService {

    @Autowired
    private TransaccionRepository cR;

    @Autowired
    private CosteRepository cosRep;


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
        return cR.findById(id).orElse(new Transaccion());
    }

    @Override
    public void updateCosts(int id) {

        Transaccion transaccion=cR.findById(id).orElse(new Transaccion());

        BigDecimal costesinicial=new BigDecimal("0.0");
        BigDecimal costesfinal=new BigDecimal("0.0");

        List<Coste> costestr=cosRep.costesLetra(transaccion);

        // Recorrer la lista con un bucle for
        for (Coste coste : costestr) {
            if(coste.getTipoCoste().equals("INICIAL") && coste.getPorcentaje()==null && coste.getMontoPorcent()==null){
                costesinicial=costesinicial.add(coste.getMonto());
            } else if (coste.getTipoCoste().equals("FINAL")&& coste.getPorcentaje()==null && coste.getMontoPorcent()==null) {
                costesfinal=costesfinal.add(coste.getMonto());
            }
            else if (coste.getTipoCoste().equals("INICIAL") && coste.getMonto()==null) {

                BigDecimal porcent = coste.getPorcentaje().divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);
                BigDecimal montocost1 = coste.getMontoPorcent().multiply(porcent);

                costesinicial=costesinicial.add(montocost1);
            }else if (coste.getTipoCoste().equals("FINAL")&& coste.getMonto()==null ) {

                BigDecimal porcent = coste.getPorcentaje().divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);
                BigDecimal montocost2 = coste.getMontoPorcent().multiply(porcent);

                costesfinal=costesfinal.add(montocost2);
            }
        }

        transaccion.setCostesIniciales(costesinicial);
        transaccion.setCostesFinales(costesfinal);
        cR.save(transaccion);
    }

}

