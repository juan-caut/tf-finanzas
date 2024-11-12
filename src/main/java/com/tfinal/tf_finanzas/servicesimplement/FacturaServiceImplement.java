package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Descuento;
import com.tfinal.tf_finanzas.entities.EstadoLetFac;
import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Transaccion;
import com.tfinal.tf_finanzas.repositories.FacturaRepository;
import com.tfinal.tf_finanzas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImplement implements FacturaService {

    @Autowired
    private FacturaRepository cR;
    @Autowired
    private DescuentoService descuentoService;
    @Autowired
    private ConversionTasaService conversionTasaService;
    @Autowired
    private EstadoLetFacService estadoLetFacService;

    @Override
    public List<Factura> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Factura fact) {
        cR.save(fact);
    }

    @Override
    public Factura listId(int id) {
        return cR.findById(id).orElse(new Factura());
    }

    @Override
    public void delete(int id, TransaccionService transaccionService) {
        List<Descuento> listaDescuento = descuentoService.list();


        List<Transaccion> transaccion = transaccionService.list();
        for (Transaccion tr : transaccion) {
            if(tr.getFactura()!=null)
            if (tr.getFactura().getIdFactura() == id) {
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

