package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "descuentos")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idescuento")
    private int idDescuento;

    @ManyToOne
    @JoinColumn(name = "transacciones_idtransaccion")

    private Transaccion transaccion;

    @Column(name = "descuento", precision = 24, scale = 15, nullable = false)
    private BigDecimal descuento;

    @Column(name = "valorneto", precision = 24, scale = 15)
    private BigDecimal valorNeto;

    @Column(name = "tcea", precision = 20, scale = 15,  nullable = false)
    private BigDecimal tcea;

    @Column(name = "valorrecibido", precision = 24, scale = 15, nullable = false)
    private BigDecimal valorRecibido;

    @Column(name = "valorentregado", precision = 24, scale = 15, nullable = false)
    private BigDecimal valorEntregado;

    // Constructor sin argumentos
    public Descuento() {
    }

    // Constructor con argumentos
    public Descuento(int idDescuento, Transaccion transaccion, BigDecimal descuento,
                     BigDecimal valorNeto, BigDecimal tcea, BigDecimal valorRecibido,
                     BigDecimal valorEntregado) {
        this.idDescuento = idDescuento;
        this.transaccion = transaccion;
        this.descuento = descuento;
        this.valorNeto = valorNeto;
        this.tcea = tcea;
        this.valorRecibido = valorRecibido;
        this.valorEntregado = valorEntregado;
    }

    // Getters y Setters
    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
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
