package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int iduser;

    @Column(name = "username", length = 200, nullable = true)
    private String username;

    @Column(name = "ident", length = 30, nullable = false)
    private String ident;

    @Column(name = "passwordd", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Column(name = "estado", length = 20, nullable = true)
    private String estado;

    @Column(name = "fechacreacion", insertable = false, updatable = false, nullable = true)
    private Date fechacreacion;

    @ManyToOne
    @JoinColumn(name = "roles_idrol", nullable = true)
    private Rol rol;

    public Usuario() {
    }

}

