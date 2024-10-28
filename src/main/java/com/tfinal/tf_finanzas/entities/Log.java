package com.tfinal.tf_finanzas.entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlog")
    private int idLog;

    @Column(name = "accion", length = 255, nullable = false)
    private String accion;

    @Column(name = "fecha", nullable = true)
    private LocalDateTime fecha;

    @Column(name = "detalles", columnDefinition = "TEXT")
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    // Constructor sin argumentos
    public Log() {
    }

    // Constructor con argumentos
    public Log(int idLog, String accion, LocalDateTime fecha, String detalles, Usuario usuario) {
        this.idLog = idLog;
        this.accion = accion;
        this.fecha = fecha;
        this.detalles = detalles;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
