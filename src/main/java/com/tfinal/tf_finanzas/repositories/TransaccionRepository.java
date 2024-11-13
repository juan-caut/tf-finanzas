package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Cartera;
import com.tfinal.tf_finanzas.entities.Coste;
import com.tfinal.tf_finanzas.entities.Letra;
import com.tfinal.tf_finanzas.entities.Transaccion;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Integer>{


    @Query("from Transaccion u where u.id_cartera=:cartera")
    List<Transaccion> listpcartera(@Param("cartera") Cartera cartera);

    @Query("from Transaccion u where u.letra.idLetra=:idlet")
    Transaccion listplet(@Param("idlet") int idlet);

    @Query("from Transaccion u where u.factura.idFactura=:idfac")
    Transaccion listpfac(@Param("idfac") int idfac);

    @Query("from Transaccion u where u.id_cartera.idCartera=:idcar")
    Transaccion listpcar(@Param("idcar") int idcar);




}
