package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Usuario;

import java.time.LocalDateTime;

public class CarteraDTO {

    private int idCartera;
    private String nombreCartera;
    private LocalDateTime fechaCreacion;
    private String tipoDoc;
    private Usuario usuarioCreador;
    private String moneda;

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
