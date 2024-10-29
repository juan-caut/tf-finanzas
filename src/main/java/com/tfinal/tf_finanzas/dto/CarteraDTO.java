package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Usuario;

import java.time.LocalDateTime;

public class CarteraDTO {

    private String nombreCartera;
    private String tipoDoc;
    private Usuario usuarioCreador;
    private String moneda;

    // Getters y Setters

    public String getNombreCartera() {
        return nombreCartera;
    }

    public void setNombreCartera(String nombreCartera) {
        this.nombreCartera = nombreCartera;
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
