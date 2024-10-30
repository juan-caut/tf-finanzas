package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private int idFactura;

    @Column(name = "numero_factura", length = 50, nullable = false)
    private String numeroFactura;

    @Column(name = "fecha_emision", nullable = true)
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = true)
    private LocalDate fechaVencimiento;

    @Column(name = "monto_total", precision = 24, scale = 15, nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "tasa_efectiva", precision = 17, scale = 15, nullable = true)
    private BigDecimal tasaEfectiva;

    @ManyToOne
    @JoinColumn(name = "id_cartera", nullable = false)
    private Cartera cartera;

    // Constructor sin argumentos
    public Factura() {
    }

    public Factura(int idFactura, String numeroFactura, LocalDate fechaEmision, LocalDate fechaVencimiento, BigDecimal montoTotal, BigDecimal tasaEfectiva, Cartera cartera) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.montoTotal = montoTotal;
        this.tasaEfectiva = tasaEfectiva;
        this.cartera = cartera;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
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

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
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
