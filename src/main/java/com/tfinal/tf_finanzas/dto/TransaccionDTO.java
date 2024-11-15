package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Letra;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransaccionDTO {


    private LocalDate fechaTransaccion;
    private int id_cartera;


    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public int getId_cartera() {
        return id_cartera;
    }

    public void setId_cartera(int id_cartera) {
        this.id_cartera = id_cartera;
    }
}
