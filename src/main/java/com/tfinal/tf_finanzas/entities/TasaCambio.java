package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tasascambio")
public class TasaCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtasascambio")
    private int idTasaCambio;

    @Column(name = "tasa", precision = 17, scale = 15, nullable = false)
    private BigDecimal tasa;

    @Column(name = "fecharegistrp", nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_cartera")
    private Cartera cartera;

    // Constructor sin argumentos
    public TasaCambio() {
    }

    // Constructor con argumentos
    public TasaCambio(int idTasaCambio, BigDecimal tasa, LocalDate fechaRegistro, Cartera cartera) {
        this.idTasaCambio = idTasaCambio;
        this.tasa = tasa;
        this.fechaRegistro = fechaRegistro;
        this.cartera = cartera;
    }

    // Getters y Setters
    public int getIdTasaCambio() {
        return idTasaCambio;
    }

    public void setIdTasaCambio(int idTasaCambio) {
        this.idTasaCambio = idTasaCambio;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }
}
