package com.tfinal.tf_finanzas.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaccionDTO2 {

    private int idTransaccion;
    private int idletra;
    private int idfactura;

    private LocalDate fechaTransaccion;

    private int diasadesc;

    private BigDecimal costesIniciales;

    private BigDecimal costesFinales;


    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdletra() {
        return idletra;
    }

    public void setIdletra(int idletra) {
        this.idletra = idletra;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public int getDiasadesc() {
        return diasadesc;
    }

    public void setDiasadesc(int diasadesc) {
        this.diasadesc = diasadesc;
    }

    public BigDecimal getCostesIniciales() {
        return costesIniciales;
    }

    public void setCostesIniciales(BigDecimal costesIniciales) {
        this.costesIniciales = costesIniciales;
    }

    public BigDecimal getCostesFinales() {
        return costesFinales;
    }

    public void setCostesFinales(BigDecimal costesFinales) {
        this.costesFinales = costesFinales;
    }

}
