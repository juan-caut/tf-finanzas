package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Usuario;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Data
public class CarteraDTO {

    private String nombreCartera;
    private String tipoDoc;
    private Usuario usuarioCreador;
    private String moneda;
    private String tasaCambio;
    private String fechaCreador;
    // Getters y Setters


}
