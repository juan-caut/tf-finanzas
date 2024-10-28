package com.tfinal.tf_finanzas.repositories;

import com.tfinal.tf_finanzas.entities.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento,Integer>{

}
