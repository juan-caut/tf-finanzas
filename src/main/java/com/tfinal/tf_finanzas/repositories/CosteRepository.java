package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Coste;
import com.tfinal.tf_finanzas.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosteRepository extends JpaRepository<Coste,Integer>{


    @Query("from Coste u where u.transaccion=:transaccion")
    List<Coste> costesLetra(@Param("transaccion") Transaccion transaccion);

}
