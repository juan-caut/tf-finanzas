package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "costes")
public class Coste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcostes")
    private int idCostes;

    @Column(name = "tipo_coste", length = 20, nullable = false)
    private String tipoCoste;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "monto", precision = 24, scale = 15)
    private BigDecimal monto;

    @Column(name = "porcentaje", precision = 17, scale = 15)
    private BigDecimal porcentaje;

    @ManyToOne
    @JoinColumn(name = "transacciones_idtransaccion", nullable = false)
    private Transaccion transaccion;

    // Constructor sin argumentos
    public Coste() {
    }

    // Constructor con argumentos
    public Coste(int idCostes, String tipoCoste, String nombre,
                 BigDecimal monto, BigDecimal porcentaje, Transaccion transaccion) {
        this.idCostes = idCostes;
        this.tipoCoste = tipoCoste;
        this.nombre = nombre;
        this.monto = monto;
        this.porcentaje = porcentaje;
        this.transaccion = transaccion;
    }

    // Getters y Setters
    public int getIdCostes() {
        return idCostes;
    }

    public void setIdCostes(int idCostes) {
        this.idCostes = idCostes;
    }

    public String getTipoCoste() {
        return tipoCoste;
    }

    public void setTipoCoste(String tipoCoste) {
        this.tipoCoste = tipoCoste;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}
