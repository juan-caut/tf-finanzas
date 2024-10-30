package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransaccion")
    private int idTransaccion;

    @ManyToOne
    @JoinColumn(name = "id_letra", nullable = true)
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = true)
    private Factura factura;

    @Column(name = "fecha_transaccion", nullable = true)
    private LocalDate fechaTransaccion;

    @Column(name = "diasadesc", nullable = true)
    private int diasadesc;

    @Column(name = "costes_iniciales", precision = 24, scale = 15, nullable = true)
    private BigDecimal costesIniciales;

    @Column(name = "costes_finales", precision = 24, scale = 15, nullable = true)
    private BigDecimal costesFinales;

    // Constructor sin argumentos
    public Transaccion() {
    }

    public Transaccion(int idTransaccion, Letra letra, Factura factura, LocalDate fechaTransaccion, int diasadesc, BigDecimal costesIniciales, BigDecimal costesFinales) {
        this.idTransaccion = idTransaccion;
        this.letra = letra;
        this.factura = factura;
        this.fechaTransaccion = fechaTransaccion;
        this.diasadesc = diasadesc;
        this.costesIniciales = costesIniciales;
        this.costesFinales = costesFinales;
    }

    // Getters y Setters
    public int getDiasadesc() {
        return diasadesc;
    }

    public void setDiasadesc(int diasadesc) {
        this.diasadesc = diasadesc;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
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
