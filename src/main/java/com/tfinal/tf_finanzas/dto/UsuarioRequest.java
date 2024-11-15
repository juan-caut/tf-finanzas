package com.tfinal.tf_finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    private String username;
    private String ident;
    private String email;
    private String passwordd;
    private int idRol;
}
