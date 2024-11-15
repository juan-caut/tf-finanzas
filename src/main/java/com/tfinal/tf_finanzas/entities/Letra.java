package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "letras")
@Data
public class Letra {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idletra")
    private int idLetra;

    @Column(name = "numero_letra", length = 50, nullable = false)
    private String numeroLetra;

    @Column(name = "fecha_emision", nullable = true)
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = true)
    private LocalDate fechaVencimiento;


    @Column(name = "valor_nominal", precision = 24, scale = 15, nullable = false)
    private BigDecimal valorNominal;

    @Column(name = "tasa_efectiva", precision = 17, scale = 15, nullable = true)
    private BigDecimal tasaEfectiva;


    @ManyToOne
    @JoinColumn(name = "id_cartera", nullable = false)
    private Cartera cartera;

    // Constructor sin argumentos
    public Letra() {
    }

    public Letra(int idLetra, String numeroLetra, LocalDate fechaEmision, LocalDate fechaVencimiento , BigDecimal valorNominal, BigDecimal tasaEfectiva, Cartera cartera) {
        this.idLetra = idLetra;
        this.numeroLetra = numeroLetra;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.valorNominal = valorNominal;
        this.tasaEfectiva = tasaEfectiva;
        this.cartera = cartera;
    }


    public int getIdLetra() {
        return idLetra;
    }

    public void setIdLetra(int idLetra) {
        this.idLetra = idLetra;
    }

    public String getNumeroLetra() {
        return numeroLetra;
    }

    public void setNumeroLetra(String numeroLetra) {
        this.numeroLetra = numeroLetra;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public BigDecimal getTasaEfectiva() {
        return tasaEfectiva;
    }

    public void setTasaEfectiva(BigDecimal tasaEfectiva) {
        this.tasaEfectiva = tasaEfectiva;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

}
