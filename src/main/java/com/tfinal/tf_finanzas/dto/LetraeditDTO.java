package com.tfinal.tf_finanzas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LetraeditDTO {
    private int id;
    private LocalDate fechaInicial;
    private LocalDate fechaVencimiento;
    private BigDecimal tasaEfectAnual;
    private BigDecimal valorNominal;
    private boolean visible;

}
