package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.dto.TransaccionDTO;
import com.tfinal.tf_finanzas.dto.TransaccionDTO2;
import com.tfinal.tf_finanzas.entities.*;
import com.tfinal.tf_finanzas.repositories.CarteraRepository;
import com.tfinal.tf_finanzas.repositories.CosteRepository;
import com.tfinal.tf_finanzas.repositories.TransaccionRepository;
import com.tfinal.tf_finanzas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransaccionServiceImplement implements TransaccionService {

    @Autowired
    private TransaccionRepository cR;

    @Autowired
    private CosteRepository cosRep;

    @Autowired
    private LetraService letSer;

    @Autowired
    private FacturaService facSer;

    @Autowired
    private DescuentoService descS;

    @Autowired
    private CarteraService carS;


    @Override
    public List<Transaccion> list() {
        return cR.findAll();
    }

    @Override
    public List<Transaccion> listporcartera(Cartera cart) {
        return cR.listpcartera(cart);
    }



    @Override
    public void insert2(TransaccionDTO2 tr) {


        List<Cartera> carList =carS.list();
        List<Descuento> listdesc=descS.list();

        Cartera cartera=new Cartera();
        for (Cartera car : carList) {
            if(letSer.listId(tr.getIdletra()).getCartera().getIdCartera()==car.getIdCartera()){
                cartera=car;
                System.out.println("obteniendo cartera........... "+cartera.getIdCartera());
            }
        }

        List<Transaccion> transac=listporcartera(cartera);

        // descS.deleteall();
        for (Transaccion t : transac) {
            for (Descuento desc1 : listdesc) {
                if (desc1.getTransaccion().getIdTransaccion()==t.getIdTransaccion()) {
                    descS.delete(desc1.getIdDescuento());
                }
            }
            if (t.getLetra().getIdLetra()==tr.getIdletra()) {
                cR.deleteById(t.getIdTransaccion());
            }

        }
        if((int)ChronoUnit.DAYS.between(tr.getFechaTransaccion(),letSer.listId(tr.getIdletra()).getFechaVencimiento())>0){
            Transaccion transaccion = new Transaccion();

            transaccion.setLetra(letSer.listId(tr.getIdletra()).getIdLetra()!=0?letSer.listId(tr.getIdletra()):null);
            System.out.println("obteniendo letra........... "+tr.getIdletra());
            System.out.println("obteniendo factura........... "+tr.getIdfactura());
            transaccion.setFactura(facSer.listId(tr.getIdfactura()).getIdFactura()!=0?facSer.listId(tr.getIdfactura()):null);

            transaccion.setCostesIniciales(tr.getCostesIniciales());
            transaccion.setCostesFinales(tr.getCostesFinales());
            transaccion.setFechaTransaccion(tr.getFechaTransaccion());
            transaccion.setDiasadesc((int)ChronoUnit.DAYS.between(tr.getFechaTransaccion(),letSer.listId(tr.getIdletra()).getFechaVencimiento()));

            transaccion.setId_cartera(cartera.getIdCartera()!=0?cartera:null);
            cR.save(transaccion);
        }

    }
    @Override
    public void insert(Transaccion tr) {
            cR.save(tr);

    }


    @Override
    public void insertvarios(TransaccionDTO tra) {

        List<Letra> listlet= letSer.findAllByCarteraIs(tra.getId_cartera());
        List<Transaccion> listtra=cR.findAll();
        List<Descuento> listdesc=descS.list();

       // descS.deleteall();
        for (Transaccion transac1 : listtra) {
            for (Descuento desc1 : listdesc) {
                if (desc1.getTransaccion().getIdTransaccion()==transac1.getIdTransaccion()) {
                    descS.delete(desc1.getIdDescuento());
                }
            }

        }

        if(!listlet.isEmpty()){
            for (Letra let : listlet) {
                for (Transaccion transac : listtra) {
                    if (transac.getLetra().getIdLetra()==let.getIdLetra()) {
                        cR.deleteById(transac.getIdTransaccion());
                    }
                }
                if((int)ChronoUnit.DAYS.between(tra.getFechaTransaccion(),let.getFechaVencimiento())>0){
                    Transaccion transaccion = new Transaccion();
                    transaccion.setDiasadesc((int) ChronoUnit.DAYS.between(tra.getFechaTransaccion(),let.getFechaVencimiento()));
                    transaccion.setLetra(let);
                    transaccion.setFechaTransaccion(tra.getFechaTransaccion());
                    transaccion.setId_cartera(carS.listId(tra.getId_cartera()));
                    cR.save(transaccion);
                }
            }
        }
    }

    @Override
    public Transaccion listId(int id) {
        return cR.findById(id).orElse(new Transaccion());
    }

    @Override
    public Transaccion listplet(int idlet) {
        return cR.listplet(idlet);
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

    @Override
    public void delete(int idTransaccion) {
        cR.deleteById(idTransaccion);
    }

}

