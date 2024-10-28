package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "conversiontasas")
public class ConversionTasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconvtasa")
    private int idConvTasa;

    @Column(name = "tasanominal", precision = 17, scale = 15,nullable = false)
    private BigDecimal tasaNominal;

    @Column(name = "tipotasa", length = 10, nullable = false)
    private String tipoTasa;

    @Column(name = "capitalizacion", nullable = false)
    private int capitalizacion;

    @Column(name = "tasa_efectiva", precision = 17, scale = 15)
    private BigDecimal tasaEfectiva;

    @ManyToOne
    @JoinColumn(name = "facturas_idfactura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "letras_idletra")
    private Letra letra;

    // Constructor sin argumentos
    public ConversionTasa() {
    }

    // Constructor con argumentos
    public ConversionTasa(int idConvTasa, BigDecimal tasaNominal, String tipoTasa,
                          int capitalizacion, BigDecimal tasaEfectiva,
                          Factura factura, Letra letra) {
        this.idConvTasa = idConvTasa;
        this.tasaNominal = tasaNominal;
        this.tipoTasa = tipoTasa;
        this.capitalizacion = capitalizacion;
        this.tasaEfectiva = tasaEfectiva;
        this.factura = factura;
        this.letra = letra;
    }

    // Getters y Setters
    public int getIdConvTasa() {
        return idConvTasa;
    }

    public void setIdConvTasa(int idConvTasa) {
        this.idConvTasa = idConvTasa;
    }

    public BigDecimal getTasaNominal() {
        return tasaNominal;
    }

    public void setTasaNominal(BigDecimal tasaNominal) {
        this.tasaNominal = tasaNominal;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public int getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(int capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public BigDecimal getTasaEfectiva() {
        return tasaEfectiva;
    }

    public void setTasaEfectiva(BigDecimal tasaEfectiva) {
        this.tasaEfectiva = tasaEfectiva;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }
}
