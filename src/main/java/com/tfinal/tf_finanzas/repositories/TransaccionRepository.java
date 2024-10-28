package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Integer>{

}
