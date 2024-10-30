package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
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
    private LocalDateTime fechacreacion;

    @ManyToOne
    @JoinColumn(name = "roles_idrol", nullable = true)
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int iduser, String username, String ident, String password, String email, String estado, LocalDateTime fechacreacion, Rol rol) {
        this.iduser = iduser;
        this.username = username;
        this.ident = ident;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.fechacreacion = fechacreacion;
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getters y Setters
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDateTime fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

