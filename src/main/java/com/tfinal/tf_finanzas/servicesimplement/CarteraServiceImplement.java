package com.tfinal.tf_finanzas.servicesimplement;


import com.tfinal.tf_finanzas.dto.ReporteDTO;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Factura;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.entities.TasaCambio;
import com.tfinal.tf_finanzas.repositories.CarteraRepository;
import com.tfinal.tf_finanzas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CarteraServiceImplement implements CarteraService {

    @Autowired
    private CarteraRepository cR;


    @Autowired
    private TasaCambioService tasaCambioService;

    @Override
    public List<Cartera> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cartera cartera) {

        cR.save(cartera);
    }

    @Override
    public Cartera listId(int id) {
        return cR.findById(id).orElse(new Cartera());
    }

    @Override
    public List<Cartera> getCarterasByUsuarioId(int usuarioId) {
        return cR.findAllByUsuarioCreador_Iduser(usuarioId);
    }
    @Override
    public List<ReporteDTO> getreport(int idcar) {
        List<ReporteDTO> listreport = new ArrayList<>();

        if(Objects.equals(listId(idcar).getTipoDoc(), "LETRA")){

            List<Map<String, Object>> resultados = cR.obtenerReporteLetrasPorCartera(idcar);

            for (Map<String, Object> fila : resultados) {

                ReporteDTO reporte = new ReporteDTO();

                reporte.setIdletfac((Integer) fila.get("ID_LETRA"));
                reporte.setNumletfac((String) fila.get("NUMERO_LETRA"));
                reporte.setFechaem(convertToLocalDate(fila.get("FECHA_EMISION_DE_LETRA")));
                reporte.setFechaven(convertToLocalDate(fila.get("FECHA_VENCIMIENTO_DE_LETRA")));
                reporte.setFechadesc(convertToLocalDate(fila.get("FECHA_DESC")));
                reporte.setValornom((BigDecimal) fila.get("VALOR_NOMINAL_DE_LETRA"));
                reporte.setTea((BigDecimal) fila.get("TASA_EFECTIVA_DE_LETRA"));
                reporte.setValorneto((BigDecimal) fila.get("VALOR_NETO"));
                reporte.setCosteinicial((BigDecimal) fila.get("COSTES_INICIAL"));
                reporte.setCostefinal((BigDecimal) fila.get("COSTES_FINALES"));
                reporte.setValorrecibido((BigDecimal) fila.get("VALOR_RECIBIDO"));
                reporte.setValorentregado((BigDecimal) fila.get("VALOR_ENTREGADO"));
                reporte.setTcea((BigDecimal) fila.get("TCEA"));

                listreport.add(reporte);
            }
        }else if(Objects.equals(listId(idcar).getTipoDoc(), "FACTURA")){

            List<Map<String, Object>> resultados = cR.obtenerReporteFacturasPorCartera(idcar);


            for (Map<String, Object> fila : resultados) {

                ReporteDTO reporte = new ReporteDTO();

                reporte.setIdletfac((Integer) fila.get("ID_LETRA"));
                reporte.setNumletfac((String) fila.get("NUMERO_LETRA"));
                reporte.setFechaem(convertToLocalDate(fila.get("FECHA_EMISION_DE_LETRA")));
                reporte.setFechaven(convertToLocalDate(fila.get("FECHA_VENCIMIENTO_DE_LETRA")));
                reporte.setFechadesc(convertToLocalDate(fila.get("FECHA_DESC")));
                reporte.setValornom((BigDecimal) fila.get("VALOR_NOMINAL_DE_LETRA"));
                reporte.setTea((BigDecimal) fila.get("TASA_EFECTIVA_DE_LETRA"));
                reporte.setValorneto((BigDecimal) fila.get("VALOR_NETO"));
                reporte.setCosteinicial((BigDecimal) fila.get("COSTES_INICIAL"));
                reporte.setCostefinal((BigDecimal) fila.get("COSTES_FINALES"));
                reporte.setValorrecibido((BigDecimal) fila.get("VALOR_RECIBIDO"));
                reporte.setValorentregado((BigDecimal) fila.get("VALOR_ENTREGADO"));
                reporte.setTcea((BigDecimal) fila.get("TCEA"));

                listreport.add(reporte);
            }
        }
        return listreport;


    }
    // Método auxiliar para convertir java.sql.Date a LocalDate
    private LocalDate convertToLocalDate(Object dateObj) {
        if (dateObj instanceof Date) {
            return ((Date) dateObj).toLocalDate();
        }
        return null; // Manejo de nulos
    }

    @Override
    public void delete(int id, TransaccionService transaccion,LetraService letraService,FacturaService facturaService) {
        List<Letra> listaletra = letraService.list();
        List<Factura> listafactura = facturaService.list();
        List<TasaCambio>listTasa=tasaCambioService.list();
        for (TasaCambio tasa : listTasa) {
            if (tasa.getCartera().getIdCartera() == id) {
                tasaCambioService.delete(id); // Pass the letra ID to ensure specific deletion
            }
        }

        for (Letra letra : listaletra) {
            if (letra.getCartera().getIdCartera() == id) {
                letraService.delete(letra.getIdLetra(), transaccion); // Pass the letra ID to ensure specific deletion
            }
        }

        // Iterate over the facturas and delete those associated with the cartera
        for (Factura factura : listafactura) {
            if (factura.getCartera().getIdCartera() == id) {
                facturaService.delete(factura.getIdFactura(), transaccion); // Pass the factura ID to ensure specific deletion
            }
        }
        cR.deleteById(id);

    }
}

