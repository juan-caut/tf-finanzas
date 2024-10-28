package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idRol;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructor sin argumentos
    public Rol() {
    }

    // Constructor con argumentos
    public Rol(int idRol, String name) {
        this.idRol = idRol;
        this.name = name;
    }

    // Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

