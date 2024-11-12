package com.tfinal.tf_finanzas.dto;

import com.tfinal.tf_finanzas.entities.Cartera;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LetraDTO {

    private String numeroLetra;

    private LocalDate fechaEmision;

    private LocalDate fechaVencimiento;

    private BigDecimal valorNominal;

    private BigDecimal tasaEfectiva;

    private int carteraid;


}
