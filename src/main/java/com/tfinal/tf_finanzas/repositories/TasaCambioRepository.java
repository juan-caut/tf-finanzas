package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.TasaCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasaCambioRepository extends JpaRepository<TasaCambio,Integer>{

}
