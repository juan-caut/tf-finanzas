package com.tfinal.tf_finanzas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransaccion")
    private int idTransaccion;

    @ManyToOne
    @JoinColumn(name = "id_letra", nullable = true)
    private Letra letra;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = true)
    private Factura factura;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDate fechaTransaccion;

    @Column(name = "diasadesc", nullable = true)
    private int diasadesc;

    @Column(name = "costes_iniciales", precision = 24, scale = 15, nullable = true)
    private BigDecimal costesIniciales;

    @Column(name = "costes_finales", precision = 24, scale = 15, nullable = true)
    private BigDecimal costesFinales;

    @ManyToOne
    @JoinColumn(name = "id_cartera", nullable = true)
    private Cartera id_cartera;

    // Constructor sin argumentos
    public Transaccion() {
    }

    public Transaccion(int idTransaccion, Letra letra, Factura factura, LocalDate fechaTransaccion, int diasadesc, BigDecimal costesIniciales, BigDecimal costesFinales, Cartera id_cartera) {
        this.idTransaccion = idTransaccion;
        this.letra = letra;
        this.factura = factura;
        this.fechaTransaccion = fechaTransaccion;
        this.diasadesc = diasadesc;
        this.costesIniciales = costesIniciales;
        this.costesFinales = costesFinales;
        this.id_cartera = id_cartera;
    }

    // Getters y Setters

}
