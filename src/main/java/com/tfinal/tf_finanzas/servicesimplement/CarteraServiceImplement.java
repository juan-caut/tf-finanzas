package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.repositories.CarteraRepository;
import com.tfinal.tf_finanzas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraServiceImplement implements CarteraService {

    @Autowired
    private CarteraRepository cR;


    @Autowired
    private TasaCambioService tasaCambioService;

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

    @Override
    public void delete(int id, TransaccionService transaccion,LetraService letraService,FacturaService facturaService) {
        List<Letra> listaletra = letraService.list();
        List<Factura> listafactura = facturaService.list();
        tasaCambioService.delete(id);
        for (Letra letra : listaletra) {
            if (letra.getCartera().getIdCartera() == id) {
                letraService.delete(letra.getIdLetra(), transaccion); // Pass the letra ID to ensure specific deletion
            }
        }

        // Iterate over the facturas and delete those associated with the cartera
        for (Factura factura : listafactura) {
            if (factura.getCartera().getIdCartera() == id) {
                facturaService.delete(factura.getIdFactura(), transaccion); // Pass the factura ID to ensure specific deletion
            }
        }
        cR.deleteById(id);

    }
}

