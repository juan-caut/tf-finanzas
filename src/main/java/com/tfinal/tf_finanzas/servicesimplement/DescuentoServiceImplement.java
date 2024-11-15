package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.entities.*;
import com.tfinal.tf_finanzas.repositories.*;
import com.tfinal.tf_finanzas.service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
public class DescuentoServiceImplement implements DescuentoService {

    @Autowired
    private DescuentoRepository cR;

    @Autowired
    private TransaccionRepository tR;

    @Autowired
    private LetraRepository letR;

    @Autowired
    private FacturaRepository facR;


    @Override
    public List<Descuento> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Descuento desc) {
        cR.save(desc);
    }

    @Override
    public Descuento listId(int id) {
        return cR.findById(id).orElse(new Descuento());
    }

    @Override
    public Descuento descontar(int idtra) {
        List<Descuento> listdesc=cR.findAll();

        for (Descuento desc1 : listdesc) {
            if (desc1.getTransaccion().getIdTransaccion()==idtra) {
                cR.deleteById(desc1.getIdDescuento());
            }
        }
        System.out.println("Registrando descuento ... ");
        insertDesc(idtra);
        System.out.println("Descuento Registrado ... ");
        List<Descuento> listdesc2=cR.findAll();
        Descuento desret=new Descuento();

        for (Descuento desc2 : listdesc2) {
            if (desc2.getTransaccion().getIdTransaccion()==idtra) {
                System.out.println("Descuento  encontrado ... "+desc2.getIdDescuento());
                desret= desc2;
            }
        }
        return desret;

    }


    @Override
    public void insertDesc(int id) {
        Transaccion transaccion = tR.findById(id).orElse(new Transaccion());
        Descuento descuento = new Descuento();
        int plazodias= transaccion.getDiasadesc();

        if(transaccion.getLetra()!=null && transaccion.getFactura()==null){
            Letra letra= letR.findById(transaccion.getLetra().getIdLetra()).orElse(new Letra());

            BigDecimal TEA=letra.getTasaEfectiva();

            //convertir TEA en una proporción
            TEA=TEA.divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);

            //calcular TEP
            BigDecimal TEPbase=TEA.add(BigDecimal.valueOf(1));
            BigDecimal TEPpotencia=new BigDecimal(plazodias/360.0);
            BigDecimal TEPr=bigDecimalPow(TEPbase, TEPpotencia, MathContext.DECIMAL64);
            BigDecimal TEP=TEPr.subtract(BigDecimal.valueOf(1));

            //calcular descuento
            BigDecimal porcentajeDescuento=TEP.divide(TEP.add(BigDecimal.valueOf(1)),15, RoundingMode.HALF_UP);
            BigDecimal montodescuento=porcentajeDescuento.multiply(letra.getValorNominal());

            //calcular valor neto
            BigDecimal valorneto=letra.getValorNominal().subtract(montodescuento);

            //calcular valor recibido
            BigDecimal valorrecibido=valorneto.subtract(transaccion.getCostesIniciales()!= null ? transaccion.getCostesIniciales() : BigDecimal.ZERO);

            //calcular valor entregado
            BigDecimal valorentregado=letra.getValorNominal().add(transaccion.getCostesFinales()!= null ? transaccion.getCostesFinales() : BigDecimal.ZERO);

            //calcular TCEA
            BigDecimal TCEAbase=valorentregado.divide(valorrecibido ,15, RoundingMode.HALF_UP);
            BigDecimal TCEApotencia = new BigDecimal(360).divide(BigDecimal.valueOf(plazodias), 15, RoundingMode.HALF_UP);
            BigDecimal TCEAr=bigDecimalPow(TCEAbase, TCEApotencia, MathContext.DECIMAL64);
            BigDecimal TCEAc=TCEAr.subtract(BigDecimal.valueOf(1));
            BigDecimal TCEA=TCEAc.multiply(BigDecimal.valueOf(100));

            descuento.setDescuento(montodescuento);
            descuento.setValorNeto(valorneto);
            descuento.setValorRecibido(valorrecibido);
            descuento.setValorEntregado(valorentregado);
            descuento.setTcea(TCEA);
            descuento.setTransaccion(transaccion);

        } else if(transaccion.getFactura()!=null && transaccion.getLetra()==null){
            Factura factura= facR.findById(transaccion.getFactura().getIdFactura()).orElse(new Factura());
            BigDecimal TEA=factura.getTasaEfectiva();

            //convertir TEA en una proporción
            TEA=TEA.divide(BigDecimal.valueOf(100),15, RoundingMode.HALF_UP);

            //calcular TEP
            BigDecimal TEPbase=TEA.add(BigDecimal.valueOf(1));
            BigDecimal TEPpotencia=new BigDecimal(plazodias/360.0);
            BigDecimal TEPr=bigDecimalPow(TEPbase, TEPpotencia, MathContext.DECIMAL64);
            BigDecimal TEP=TEPr.subtract(BigDecimal.valueOf(1));

            //calcular descuento
            BigDecimal porcentajeDescuento=TEP.divide(TEP.add(BigDecimal.valueOf(1)),15, RoundingMode.HALF_UP);
            BigDecimal montodescuento=porcentajeDescuento.multiply(factura.getMontoTotal());

            //calcular valor neto
            BigDecimal valorneto=factura.getMontoTotal().subtract(montodescuento);

            //calcular valor recibido
            BigDecimal valorrecibido=valorneto.subtract(transaccion.getCostesIniciales());

            //calcular valor entregado
            BigDecimal valorentregado=factura.getMontoTotal().add(transaccion.getCostesFinales());

            //calcular TCEA
            BigDecimal TCEAbase=valorentregado.divide(valorrecibido ,15, RoundingMode.HALF_UP);
            BigDecimal TCEApotencia = new BigDecimal(360).divide(BigDecimal.valueOf(plazodias), 15, RoundingMode.HALF_UP);
            BigDecimal TCEAr=bigDecimalPow(TCEAbase, TCEApotencia, MathContext.DECIMAL64);
            BigDecimal TCEAc=TCEAr.subtract(BigDecimal.valueOf(1));
            BigDecimal TCEA=TCEAc.multiply(BigDecimal.valueOf(100));

            descuento.setDescuento(montodescuento);
            descuento.setValorNeto(valorneto);
            descuento.setValorRecibido(valorrecibido);
            descuento.setValorEntregado(valorentregado);
            descuento.setTcea(TCEA);
            descuento.setTransaccion(transaccion);
        }
        cR.save(descuento);

    }

    @Override
    public void deleteall() {
        cR.deleteAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }


    // Método para calcular la potencia base ^ exponente usando logaritmos y exponenciales
    public static BigDecimal bigDecimalPow(BigDecimal base, BigDecimal exponente, MathContext mc) {
        // Validar que la base no sea negativa


        // ln(base) * exponente
        BigDecimal logBase = BigDecimal.valueOf(Math.log(base.doubleValue()));
        BigDecimal exponenteLogBase = logBase.multiply(exponente, mc);

        // e^(ln(base) * exponente)
        double expResult = Math.exp(exponenteLogBase.doubleValue());

        // Devolver el resultado como BigDecimal
        return new BigDecimal(expResult, mc);
    }
}

