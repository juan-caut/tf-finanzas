package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.repositories.LetraRepository;
import com.tfinal.tf_finanzas.service.CarteraService;
import com.tfinal.tf_finanzas.service.LetraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetraServiceImplement implements LetraService {

    @Autowired
    private LetraRepository cR;
    @Autowired
    private CarteraServiceImplement cS;


    @Override
    public List<Letra> list() {
        return cR.findAll();
    }

    @Override
    public Letra insert(LetraDTO letraDTO) {
            Cartera cartera = cS.listId(letraDTO.getCarteraid());
            Letra letra = new Letra();
            letra.setNumeroLetra(letraDTO.getNumeroLetra());
            letra.setFechaEmision(letraDTO.getFechaEmision());
            letra.setFechaVencimiento(letraDTO.getFechaVencimiento());
            letra.setValorNominal(letraDTO.getValorNominal());
            letra.setTasaEfectiva(letraDTO.getTasaEfectiva());
            letra.setCartera(cartera);
                return cR.save(letra);
        }

    @Override
    public void insertuptade(Letra let) {

        cR.save(let);
    }

    @Override
    public Letra listId(int id) {
        return cR.findById( id).orElse(new Letra());
    }

    @Override
    public List<Letra> findAllByCarteraIs(int carteraId) {
        return cR.findAllByCartera_IdCartera(carteraId);
    }
}

