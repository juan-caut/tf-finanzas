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
    @JoinColumn(name = "id_letra")
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDate fechaTransaccion;

    @Column(name = "costes_iniciales", precision = 24, scale = 15)
    private BigDecimal costesIniciales;

    @Column(name = "costes_finales", precision = 24, scale = 15)
    private BigDecimal costesFinales;

    // Constructor sin argumentos
    public Transaccion() {
    }

    // Constructor con argumentos
    public Transaccion(int idTransaccion, Letra letra, Factura factura,
                       LocalDate fechaTransaccion, BigDecimal costesIniciales,
                       BigDecimal costesFinales) {
        this.idTransaccion = idTransaccion;
        this.letra = letra;
        this.factura = factura;
        this.fechaTransaccion = fechaTransaccion;
        this.costesIniciales = costesIniciales;
        this.costesFinales = costesFinales;
    }

    // Getters y Setters
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
