package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.dto.LetraDTO;
import com.tfinal.tf_finanzas.dto.LetraeditDTO;
import com.tfinal.tf_finanzas.entities.*;
import com.tfinal.tf_finanzas.repositories.LetraRepository;
import com.tfinal.tf_finanzas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LetraServiceImplement implements LetraService {

    @Autowired
    private LetraRepository cR;
    @Autowired
    private CarteraService cS;
    @Autowired
    private DescuentoService descuentoService;
    @Autowired
    private ConversionTasaService conversionTasaService;
    @Autowired
    private EstadoLetFacService estadoLetFacService;

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
    public void insertuptade(LetraeditDTO let) {
        Letra letrareal = listId(let.getId());
        Letra letra = new Letra();
        Cartera cartera = cS.listId(let.getId());
        letra.setIdLetra(letrareal.getIdLetra());
        letra.setNumeroLetra(letrareal.getNumeroLetra());
        letra.setFechaEmision(let.getFechaInicial());
        letra.setFechaVencimiento(let.getFechaVencimiento());
        letra.setValorNominal((let.getValorNominal()));
        letra.setTasaEfectiva(let.getTasaEfectAnual());

        letra.setCartera(cartera);
        cR.save(letra);
    }

    @Override
    public Letra listId(int id) {
        return cR.findById(id).orElse(new Letra());
    }

    @Override
    public List<Letra> findAllByCarteraIs(int carteraId) {
        return cR.findAllByCartera_IdCartera(carteraId);
    }

    public void generartransaccion(TransaccionService transaccionService) {

    }

    @Override
    public void delete(int id, TransaccionService transaccionService) {
        List<Descuento> listaDescuento = descuentoService.list();


        List<Transaccion> transaccion = transaccionService.list();
        for (Transaccion tr : transaccion) {
            if (tr.getLetra().getIdLetra() == id) {
                for (Descuento des : listaDescuento) {
                    if (des.getTransaccion().getIdTransaccion() == tr.getIdTransaccion()) {
                        descuentoService.delete(des.getIdDescuento());
                    }
                }
                transaccionService.delete(tr.getIdTransaccion());
            }
        }

        List<EstadoLetFac> listEstadoletFact = estadoLetFacService.list();
        for (EstadoLetFac tr : listEstadoletFact) {
            if (tr.getLetra().getIdLetra() == id) {
                estadoLetFacService.delete(tr.getIdEstado());
            }
        }

        cR.deleteById(id);
    }
}

