package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoletfac")
public class EstadoLetFac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private int idEstado;

    @Column(name = "nombre_estado", length = 50, nullable = false)
    private String nombreEstado;

    @ManyToOne
    @JoinColumn(name = "letras_idletra")
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "facturas_idfactura")
    private Factura factura;

    // Constructor sin argumentos
    public EstadoLetFac() {
    }

    // Constructor con argumentos
    public EstadoLetFac(int idEstado, String nombreEstado, Letra letra, Factura factura) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
        this.letra = letra;
        this.factura = factura;
    }

    // Getters y Setters
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
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
}
