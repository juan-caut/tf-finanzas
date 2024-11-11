package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Transaccion;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DescuentoDTO {

    private int idDescuento;
    private int idtransaccion;

    private BigDecimal descuento;

    private BigDecimal valorNeto;

    private BigDecimal tcea;

    private BigDecimal valorRecibido;

    private BigDecimal valorEntregado;

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(BigDecimal valorNeto) {
        this.valorNeto = valorNeto;
    }

    public BigDecimal getTcea() {
        return tcea;
    }

    public void setTcea(BigDecimal tcea) {
        this.tcea = tcea;
    }

    public BigDecimal getValorRecibido() {
        return valorRecibido;
    }

    public void setValorRecibido(BigDecimal valorRecibido) {
        this.valorRecibido = valorRecibido;
    }

    public BigDecimal getValorEntregado() {
        return valorEntregado;
    }

    public void setValorEntregado(BigDecimal valorEntregado) {
        this.valorEntregado = valorEntregado;
    }
}
