package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Usuario;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReporteDTO {
    private int idletfac ;
    private String numletfac;
    private LocalDate fechaem;
    private LocalDate fechaven;
    private BigDecimal valornom;
    private BigDecimal tea;
    private LocalDate fechadesc;
    private BigDecimal valorneto;
    private BigDecimal costeinicial;
    private BigDecimal costefinal;
    private BigDecimal valorrecibido;
    private BigDecimal valorentregado;
    private BigDecimal tcea;

    public int getIdletfac() {
        return idletfac;
    }

    public void setIdletfac(int idletfac) {
        this.idletfac = idletfac;
    }

    public String getNumletfac() {
        return numletfac;
    }

    public void setNumletfac(String numletfac) {
        this.numletfac = numletfac;
    }

    public LocalDate getFechaem() {
        return fechaem;
    }

    public void setFechaem(LocalDate fechaem) {
        this.fechaem = fechaem;
    }

    public LocalDate getFechaven() {
        return fechaven;
    }

    public void setFechaven(LocalDate fechaven) {
        this.fechaven = fechaven;
    }

    public BigDecimal getValornom() {
        return valornom;
    }

    public void setValornom(BigDecimal valornom) {
        this.valornom = valornom;
    }

    public BigDecimal getTea() {
        return tea;
    }

    public void setTea(BigDecimal tea) {
        this.tea = tea;
    }

    public LocalDate getFechadesc() {
        return fechadesc;
    }

    public void setFechadesc(LocalDate fechadesc) {
        this.fechadesc = fechadesc;
    }

    public BigDecimal getValorneto() {
        return valorneto;
    }

    public void setValorneto(BigDecimal valorneto) {
        this.valorneto = valorneto;
    }

    public BigDecimal getCosteinicial() {
        return costeinicial;
    }

    public void setCosteinicial(BigDecimal costeinicial) {
        this.costeinicial = costeinicial;
    }

    public BigDecimal getCostefinal() {
        return costefinal;
    }

    public void setCostefinal(BigDecimal costefinal) {
        this.costefinal = costefinal;
    }

    public BigDecimal getValorrecibido() {
        return valorrecibido;
    }

    public void setValorrecibido(BigDecimal valorrecibido) {
        this.valorrecibido = valorrecibido;
    }

    public BigDecimal getValorentregado() {
        return valorentregado;
    }

    public void setValorentregado(BigDecimal valorentregado) {
        this.valorentregado = valorentregado;
    }

    public BigDecimal getTcea() {
        return tcea;
    }

    public void setTcea(BigDecimal tcea) {
        this.tcea = tcea;
    }
}
