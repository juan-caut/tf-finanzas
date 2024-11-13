package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.dto.CarteraDTO;
import com.tfinal.tf_finanzas.dto.ReporteDTO;
import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Transaccion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Integer> {

    List<Cartera> findAllByUsuarioCreador_Iduser(int usuarioId);

    @Query(value = """
        SELECT  l.idletra AS "ID_LETRA", 
                l.numero_letra AS "NUMERO_LETRA",
                l.fecha_emision AS "FECHA_EMISION_DE_LETRA",
                l.fecha_vencimiento AS "FECHA_VENCIMIENTO_DE_LETRA",
                l.valor_nominal AS "VALOR_NOMINAL_DE_LETRA",
                l.tasa_efectiva AS "TASA_EFECTIVA_DE_LETRA",
                t.fecha_transaccion AS "FECHA_DESC",
                d.descuento AS "VALOR_NETO",
                t.costes_iniciales AS "COSTES_INICIAL",
                t.costes_finales AS "COSTES_FINALES",
                d.valorrecibido AS "VALOR_RECIBIDO",
                d.valorentregado AS "VALOR_ENTREGADO",
                d.tcea AS "TCEA"
        FROM letras l
            JOIN transacciones t ON l.idletra = t.id_letra                            
            JOIN descuentos d ON t.idtransaccion = d.transacciones_idtransaccion
        WHERE l.id_cartera =:idcart;
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerReporteLetrasPorCartera(@Param("idcart") int idcart);

    @Query(value = """
        SELECT  l.idfactura AS "ID_LETRA", 
                l.numero_factura AS "NUMERO_LETRA",
                l.fecha_emision AS "FECHA_EMISION_DE_LETRA",
                l.fecha_vencimiento AS "FECHA_VENCIMIENTO_DE_LETRA",
                l.monto_total AS "VALOR_NOMINAL_DE_LETRA",
                l.tasa_efectiva AS "TASA_EFECTIVA_DE_LETRA",
                t.fecha_transaccion AS "FECHA_DESC",
                d.descuento AS "VALOR_NETO",
                t.costes_iniciales AS "COSTES_INICIAL",
                t.costes_finales AS "COSTES_FINALES",
                d.valorrecibido AS "VALOR_RECIBIDO",
                d.valorentregado AS "VALOR_ENTREGADO",
                d.tcea AS "TCEA"
        FROM facturas l
            JOIN transacciones t ON l.idfactura = t.id_factura                          
            JOIN descuentos d ON t.idtransaccion = d.transacciones_idtransaccion
        WHERE l.id_cartera =:idcart;
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerReporteFacturasPorCartera(@Param("idcart") int idcart);
}
