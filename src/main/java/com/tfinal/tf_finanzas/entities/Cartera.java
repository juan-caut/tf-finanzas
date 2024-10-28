package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carteras")
public class Cartera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcartera")
    private int idCartera;

    @Column(name = "nombrecartera", length = 50, nullable = false)
    private String nombreCartera;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "tipo_doc", length = 30, nullable = false)
    private String tipoDoc;

    @Column(name = "moneda", length = 10, nullable = true)
    private String moneda;

    @ManyToOne
    @JoinColumn(name = "usuario_creador", nullable = false)
    private Usuario usuarioCreador;


    // Constructor sin argumentos
    public Cartera() {
    }

    // Constructor con argumentos
    public Cartera(int idCartera, String nombreCartera, LocalDateTime fechaCreacion,
                   String tipoDoc, Usuario usuarioCreador, String moneda) {
        this.idCartera = idCartera;
        this.nombreCartera = nombreCartera;
        this.fechaCreacion = fechaCreacion;
        this.tipoDoc = tipoDoc;
        this.usuarioCreador = usuarioCreador;
        this.moneda = moneda;
    }

    // Getters y Setters
    public int getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }

    public String getNombreCartera() {
        return nombreCartera;
    }

    public void setNombreCartera(String nombreCartera) {
        this.nombreCartera = nombreCartera;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}