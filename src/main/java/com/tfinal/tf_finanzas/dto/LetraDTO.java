package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Cartera;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LetraDTO {
    // Getters y Setters

    private int idLetra;

    private String numeroLetra;

    private LocalDate fechaEmision;

    private LocalDate fechaVencimiento;

    private BigDecimal valorNominal;

    private BigDecimal tasaEfectiva;

    private int carteraid;

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

    public int getCarteraid() {
        return carteraid;
    }

    public void setCarteraid(int carteraid) {
        this.carteraid = carteraid;
    }
}
